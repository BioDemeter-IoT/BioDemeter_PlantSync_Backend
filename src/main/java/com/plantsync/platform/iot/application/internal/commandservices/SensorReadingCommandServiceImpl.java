package com.plantsync.platform.iot.application.internal.commandservices;

import com.plantsync.platform.iot.domain.model.commands.CreateActuatorCommand;
import com.plantsync.platform.iot.domain.model.commands.CreateReadingCommand;
import com.plantsync.platform.iot.domain.model.entities.SensorReading;
import com.plantsync.platform.iot.domain.model.queries.GetNodeByIdQuery;
import com.plantsync.platform.iot.domain.model.valueobjects.ActuatorAction;
import com.plantsync.platform.iot.domain.model.valueobjects.ActuatorType;
import com.plantsync.platform.iot.domain.model.valueobjects.BuzzerMode;
import com.plantsync.platform.iot.domain.model.valueobjects.DesiredActuatorState;
import com.plantsync.platform.iot.domain.model.valueobjects.LedMode;
import com.plantsync.platform.iot.domain.model.valueobjects.ServoMode;
import com.plantsync.platform.iot.domain.services.ActuatorCommandService;
import com.plantsync.platform.iot.domain.services.IoTNodeQueryService;
import com.plantsync.platform.iot.domain.services.SensorReadingCommandService;
import com.plantsync.platform.iot.infrastructure.persistence.jpa.repositories.IotNodeRepository;
import com.plantsync.platform.iot.infrastructure.persistence.jpa.repositories.IotSensorReadingRepository;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantByIdQuery;
import com.plantsync.platform.plantprofiles.domain.services.PlantQueryService;
import org.springframework.stereotype.Service;

@Service
public class SensorReadingCommandServiceImpl implements SensorReadingCommandService {

  private static final int GAS_THRESHOLD = 35;

  private final IotSensorReadingRepository iotSensorReadingRepository;
  private final ActuatorCommandService actuatorCommandService;
  private final IoTNodeQueryService iotNodeQueryService;
  private final PlantQueryService plantQueryService;
  private final IotNodeRepository iotNodeRepository;

  public SensorReadingCommandServiceImpl(IotSensorReadingRepository iotSensorReadingRepository,
                                          ActuatorCommandService actuatorCommandService,
                                          IoTNodeQueryService iotNodeQueryService,
                                          PlantQueryService plantQueryService,
                                          IotNodeRepository iotNodeRepository) {
    this.iotSensorReadingRepository = iotSensorReadingRepository;
    this.actuatorCommandService = actuatorCommandService;
    this.iotNodeQueryService = iotNodeQueryService;
    this.plantQueryService = plantQueryService;
    this.iotNodeRepository = iotNodeRepository;
  }

  @Override
  public SensorReading handle(CreateReadingCommand command) {
    var reading = new SensorReading(command);
    var savedReading = iotSensorReadingRepository.save(reading);

    evaluateActuatorRules(command);

    return savedReading;
  }

  private void evaluateActuatorRules(CreateReadingCommand command) {
    var nodeOpt = iotNodeQueryService.handle(new GetNodeByIdQuery(command.nodeId()));
    if (nodeOpt.isEmpty()) {
      return;
    }
    var node = nodeOpt.get();

    // Gas above threshold → BUZZER
    if (command.gasPercent() != null && command.gasPercent() > GAS_THRESHOLD) {
      var actuatorCommand = new CreateActuatorCommand(
          command.nodeId(),
          ActuatorType.BUZZER,
          ActuatorAction.ACTIVATE);
      actuatorCommandService.handle(actuatorCommand);
      node.setDesiredState(new DesiredActuatorState(
          BuzzerMode.ON,
          node.getDesiredState().servoMode(),
          node.getDesiredState().ledMode()
      ));
    }

    if (node.getPlantId() == null) {
      iotNodeRepository.save(node);
      return;
    }

    var plantOpt = plantQueryService.handle(new GetPlantByIdQuery(node.getPlantId().value()));
    if (plantOpt.isEmpty()) {
      iotNodeRepository.save(node);
      return;
    }
    var plant = plantOpt.get();

    // Humidity below min → SERVO (watering)
    if (command.humidityPercent() != null && plant.getHumidityThresholdMin() != null
        && command.humidityPercent() < plant.getHumidityThresholdMin()) {
      var actuatorCommand = new CreateActuatorCommand(
          command.nodeId(),
          ActuatorType.SERVO,
          ActuatorAction.ACTIVATE);
      actuatorCommandService.handle(actuatorCommand);
      node.setDesiredState(new DesiredActuatorState(
          node.getDesiredState().buzzerMode(),
          ServoMode.ON,
          node.getDesiredState().ledMode()
      ));
    }

    // Light below min → UV_LIGHT
    if (command.lightPercent() != null && plant.getLightThresholdMin() != null
        && command.lightPercent() < plant.getLightThresholdMin()) {
      var actuatorCommand = new CreateActuatorCommand(
          command.nodeId(),
          ActuatorType.UV_LIGHT,
          ActuatorAction.ACTIVATE);
      actuatorCommandService.handle(actuatorCommand);
      node.setDesiredState(new DesiredActuatorState(
          node.getDesiredState().buzzerMode(),
          node.getDesiredState().servoMode(),
          LedMode.ON
      ));
    }

    // Temperature outside range → BUZZER
    if (command.airTemperature() != null) {
      boolean belowMin = plant.getTemperatureThresholdMin() != null
          && command.airTemperature() < plant.getTemperatureThresholdMin();
      boolean aboveMax = plant.getTemperatureThresholdMax() != null
          && command.airTemperature() > plant.getTemperatureThresholdMax();
      if (belowMin || aboveMax) {
        var actuatorCommand = new CreateActuatorCommand(
            command.nodeId(),
            ActuatorType.BUZZER,
            ActuatorAction.ACTIVATE);
        actuatorCommandService.handle(actuatorCommand);
        node.setDesiredState(new DesiredActuatorState(
            BuzzerMode.ON,
            node.getDesiredState().servoMode(),
            node.getDesiredState().ledMode()
        ));
      }
    }

    iotNodeRepository.save(node);
  }
}
