package com.plantsync.platform.plantprofiles.interfaces.rest.resources;

/**
 * The type Create plant resource.
 */
public record CreatePlantResource(


    String name,
    String species,
    String description,
    String acquisitionDate,
    String humidity,
    String nextWateringDate,
    String imageUrl,
    Boolean notificationsEnabled,
    Long profileId

) {

  /**
   * Instantiates a new Create plant resource.
   *
   * @param name                 the name
   * @param species              the species
   * @param description          the description
   * @param acquisitionDate      the acquisition date
   * @param humidity             the humidity
   * @param nextWateringDate     the next watering date
   * @param imageUrl             the image url
   * @param notificationsEnabled the notifications enabled
   * @param profileId            the profile id
   */
  public CreatePlantResource {


  }

}
