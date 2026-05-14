package com.plantsync.platform.plantprofiles.interfaces.rest.resources;

/**
 * The type Create plant history resource.
 */
public record CreatePlantHistoryResource(


    Long plantId,
    String type,
    String date,
    String time,
    Integer humidity

) {

  /**
   * Instantiates a new Create plant history resource.
   *
   * @param plantId  the plant id
   * @param type     the type
   * @param date     the date
   * @param time     the time
   * @param humidity the humidity
   */
  public CreatePlantHistoryResource {
  }
}
