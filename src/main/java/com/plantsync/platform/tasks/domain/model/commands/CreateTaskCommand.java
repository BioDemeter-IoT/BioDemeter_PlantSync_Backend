package com.plantsync.platform.tasks.domain.model.commands;

import com.plantsync.platform.tasks.domain.model.valueobjects.PlantId;
import com.plantsync.platform.tasks.domain.model.valueobjects.ProfileId;
import java.time.LocalDate;

/**
 * The type Create task command.
 */
public record CreateTaskCommand(

    LocalDate date,
    String action,
    Boolean completed,
    PlantId plantId,
    ProfileId profileId


) {

  /**
   * Instantiates a new Create task command.
   *
   * @param date      the date
   * @param action    the action
   * @param completed the completed
   * @param plantId   the plant id
   * @param profileId the profile id
   */
  public CreateTaskCommand {

  }
}