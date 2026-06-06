package com.plantsync.platform.iot.application.internal.commandservices;

import com.plantsync.platform.iot.domain.model.commands.CreateActuatorCommand;
import com.plantsync.platform.iot.domain.model.entities.ActuatorCommand;
import com.plantsync.platform.iot.domain.services.ActuatorCommandService;
import com.plantsync.platform.iot.infrastructure.persistence.jpa.repositories.ActuatorCommandRepository;
import org.springframework.stereotype.Service;

@Service
public class ActuatorCommandServiceImpl implements ActuatorCommandService {

  private final ActuatorCommandRepository actuatorCommandRepository;

  public ActuatorCommandServiceImpl(ActuatorCommandRepository actuatorCommandRepository) {
    this.actuatorCommandRepository = actuatorCommandRepository;
  }

  @Override
  public ActuatorCommand handle(CreateActuatorCommand command) {
    var actuatorCommand = new ActuatorCommand(command);
    return actuatorCommandRepository.save(actuatorCommand);
  }
}
