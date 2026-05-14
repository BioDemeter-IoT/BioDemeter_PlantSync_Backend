package com.plantsync.platform.plantprofiles.interfaces.rest.resources;

public record PlantResource(
    Long id,
    String name,
    String species,
    String acquisitionDate,
    String humidity,
    String nextWateringDate,
    String imageUrl,
    Boolean notificationsEnabled,
    Long profileId

) {
}
