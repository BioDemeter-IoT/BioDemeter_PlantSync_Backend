package com.plantsync.platform.plantprofiles.interfaces.rest.resources;

/**
 * The type Plant resource.
 */
public record PlantResource(
    Long id,
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
}
