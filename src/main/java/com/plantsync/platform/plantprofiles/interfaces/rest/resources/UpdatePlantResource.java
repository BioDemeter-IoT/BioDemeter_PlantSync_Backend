package com.plantsync.platform.plantprofiles.interfaces.rest.resources;

/**
 * The type Update plant resource.
 */
public record UpdatePlantResource(

    String name,
    String species,
    String acquisitionDate,
    String humidity,
    String nextWateringDate,
    String imageUrl,
    Boolean notificationsEnabled,
    Long profileId

) {
  /**
   * Validates the resource.
   *
   * @param name                 the name
   * @param species              the species
   * @param acquisitionDate      the acquisition date
   * @param humidity             the humidity
   * @param nextWateringDate     the next watering date
   * @param imageUrl             the image url
   * @param notificationsEnabled the notifications enabled
   * @param profileId            the profile id
   * @throws IllegalArgumentException if the title or description is null or blank.
   */
  public UpdatePlantResource {

  }
}