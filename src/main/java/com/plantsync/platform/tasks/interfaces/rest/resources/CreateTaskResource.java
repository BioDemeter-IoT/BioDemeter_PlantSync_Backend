package com.plantsync.platform.tasks.interfaces.rest.resources;

/**
 * The type Create task resource.
 */
public record CreateTaskResource(

    String action,
    String date,
    Long plantId,
    Long profileId,
    Boolean completed

) {

  /**
   * Instantiates a new Create task resource.
   *
   * @param action    the action
   * @param date      the date
   * @param plantId   the plant id
   * @param profileId the profile id
   * @param completed the completed
   */
  public CreateTaskResource {

  }

}
