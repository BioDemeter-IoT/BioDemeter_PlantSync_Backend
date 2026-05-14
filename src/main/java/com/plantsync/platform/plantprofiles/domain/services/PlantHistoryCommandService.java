package com.plantsync.platform.plantprofiles.domain.services;

import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantHistoryCommand;

public interface PlantHistoryCommandService {

  Long handle(CreatePlantHistoryCommand command);

}
