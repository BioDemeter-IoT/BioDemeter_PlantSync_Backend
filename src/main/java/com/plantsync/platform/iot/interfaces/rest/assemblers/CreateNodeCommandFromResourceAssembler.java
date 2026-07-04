package com.plantsync.platform.iot.interfaces.rest.assemblers;

import com.plantsync.platform.iot.domain.model.commands.CreateNodeCommand;
import com.plantsync.platform.iot.interfaces.rest.resources.CreateNodeResource;
import com.plantsync.platform.shared.domain.model.valueobjects.PlantId;

public class CreateNodeCommandFromResourceAssembler {

  public static CreateNodeCommand toCommandFromResource(CreateNodeResource resource) {
    return new CreateNodeCommand(
        resource.nodeCode(),
        resource.plantId() != null ? new PlantId(resource.plantId()) : null
    );
  }
}
