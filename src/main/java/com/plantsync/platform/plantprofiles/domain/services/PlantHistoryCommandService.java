package com.plantsync.platform.plantprofiles.domain.services;

import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantHistoryCommand;

/**
 * The interface Plant history command service.
 */
public interface PlantHistoryCommandService {

  /**
   * Handle long.
   *
   * @param command the command
   * @return the long
   */
  Long handle(CreatePlantHistoryCommand command);

}
