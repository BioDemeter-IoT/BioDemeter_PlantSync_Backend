package com.plantsync.platform.iot.application.internal.commandservices;

import com.plantsync.platform.iot.domain.model.commands.CreateActuatorCommand;
import com.plantsync.platform.iot.domain.model.commands.CreateReadingCommand;
import com.plantsync.platform.iot.domain.model.entities.SensorReading;
import com.plantsync.platform.iot.domain.model.queries.GetNodeByIdQuery;
import com.plantsync.platform.iot.domain.model.valueobjects.ActuatorAction;
import com.plantsync.platform.iot.domain.model.valueobjects.ActuatorType;
import com.plantsync.platform.iot.domain.services.ActuatorCommandService;
import com.plantsync.platform.iot.domain.services.IoTNodeQueryService;
import com.plantsync.platform.iot.domain.services.SensorReadingCommandService;
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

  public SensorReadingCommandServiceImpl(IotSensorReadingRepository iotSensorReadingRepository,
                                          ActuatorCommandService actuatorCommandService,
                                          IoTNodeQueryService iotNodeQueryService,
                                          PlantQueryService plantQueryService) {
    this.iotSensorReadingRepository = iotSensorReadingRepository;
    this.actuatorCommandService = actuatorCommandService;
    this.iotNodeQueryService = iotNodeQueryService;
    this.plantQueryService = plantQueryService;
  }

  @Override
  public SensorReading handle(CreateReadingCommand command) {
    var reading = new SensorReading(command);
    var savedReading = iotSensorReadingRepository.save(reading);

    evaluateActuatorRules(command);

    return savedReading;
  }

  private void evaluateActuatorRules(CreateReadingCommand command) {
    if (command.gasPercent() != null && command.gasPercent() > GAS_THRESHOLD) {
      var actuatorCommand = new CreateActuatorCommand(
          command.nodeId(),
          ActuatorType.BUZZER,
          ActuatorAction.ACTIVATE);
      actuatorCommandService.handle(actuatorCommand);
    }

    if (command.airTemperature() == null) {
      return;
    }

    var nodeOpt = iotNodeQueryService.handle(new GetNodeByIdQuery(command.nodeId()));
    if (nodeOpt.isEmpty()) {
      return;
    }
    var node = nodeOpt.get();
    if (node.getPlantId() == null) {
      return;
    }

    var plantOpt = plantQueryService.handle(new GetPlantByIdQuery(node.getPlantId().value()));
    if (plantOpt.isEmpty()) {
      return;
    }
    var plant = plantOpt.get();
    var thresholdMax = plant.getTemperatureThresholdMax();
    if (thresholdMax != null && command.airTemperature() > thresholdMax) {
      var actuatorCommand = new CreateActuatorCommand(
          command.nodeId(),
          ActuatorType.UV_LIGHT,
          ActuatorAction.ACTIVATE);
      actuatorCommandService.handle(actuatorCommand);
    }
  }
}
