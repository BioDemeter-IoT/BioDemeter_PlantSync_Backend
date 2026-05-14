package com.plantsync.platform.plantprofiles.interfaces.rest.resources;

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
     * @throws IllegalArgumentException if the title or description is null or blank.
     */
    public UpdatePlantResource {

    }
}