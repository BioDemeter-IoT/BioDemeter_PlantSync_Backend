package com.plantsync.platform.iot.application.internal.commandservices;

import com.plantsync.platform.iot.domain.model.commands.CreateActuatorCommand;
import com.plantsync.platform.iot.domain.model.commands.CreateReadingCommand;
import com.plantsync.platform.iot.domain.model.entities.SensorReading;
import com.plantsync.platform.iot.domain.model.valueobjects.ActuatorAction;
import com.plantsync.platform.iot.domain.model.valueobjects.ActuatorType;
import com.plantsync.platform.iot.domain.services.ActuatorCommandService;
import com.plantsync.platform.iot.domain.services.SensorReadingCommandService;
import com.plantsync.platform.iot.infrastructure.persistence.jpa.repositories.IotSensorReadingRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorReadingCommandServiceImpl implements SensorReadingCommandService {

  private static final float TEMPERATURE_THRESHOLD = 30.0f;

  private final IotSensorReadingRepository iotSensorReadingRepository;
  private final ActuatorCommandService actuatorCommandService;

  public SensorReadingCommandServiceImpl(IotSensorReadingRepository iotSensorReadingRepository,
                                          ActuatorCommandService actuatorCommandService) {
    this.iotSensorReadingRepository = iotSensorReadingRepository;
    this.actuatorCommandService = actuatorCommandService;
  }

  @Override
  public SensorReading handle(CreateReadingCommand command) {
    var reading = new SensorReading(command);
    var savedReading = iotSensorReadingRepository.save(reading);

    if (command.airTemperature() > TEMPERATURE_THRESHOLD) {
      var actuatorCommand = new CreateActuatorCommand(
          command.nodeId(),
          ActuatorType.UV_LIGHT,
          ActuatorAction.ACTIVATE);
      actuatorCommandService.handle(actuatorCommand);
    }

    return savedReading;
  }
}
