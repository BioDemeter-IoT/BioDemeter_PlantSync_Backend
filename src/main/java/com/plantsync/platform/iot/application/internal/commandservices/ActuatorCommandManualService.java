package com.plantsync.platform.iot.application.internal.commandservices;

import com.plantsync.platform.iot.domain.model.commands.CreateActuatorCommand;
import com.plantsync.platform.iot.domain.model.entities.ActuatorCommand;
import com.plantsync.platform.iot.domain.model.queries.GetNodeByNodeCodeQuery;
import com.plantsync.platform.iot.domain.model.valueobjects.ActuatorAction;
import com.plantsync.platform.iot.domain.model.valueobjects.ActuatorType;
import com.plantsync.platform.iot.domain.services.ActuatorCommandService;
import com.plantsync.platform.iot.domain.services.IoTNodeQueryService;
import org.springframework.stereotype.Service;

@Service
public class ActuatorCommandManualService {

  private final IoTNodeQueryService iotNodeQueryService;
  private final ActuatorCommandService actuatorCommandService;

  public ActuatorCommandManualService(IoTNodeQueryService iotNodeQueryService,
                                       ActuatorCommandService actuatorCommandService) {
    this.iotNodeQueryService = iotNodeQueryService;
    this.actuatorCommandService = actuatorCommandService;
  }

  public ActuatorCommand handle(String nodeCode, ActuatorType actuatorType, ActuatorAction action) {
    var nodeOpt = iotNodeQueryService.handle(new GetNodeByNodeCodeQuery(nodeCode));
    if (nodeOpt.isEmpty()) {
      throw new IllegalArgumentException("Node not found: " + nodeCode);
    }
    var command = new CreateActuatorCommand(nodeOpt.get().getId(), actuatorType, action);
    return actuatorCommandService.handle(command);
  }
}
