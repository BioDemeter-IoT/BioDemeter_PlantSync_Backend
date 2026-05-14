package com.plantsync.platform.plantprofiles.domain.exceptions;

public class PlantDeletionException extends RuntimeException {
    public PlantDeletionException(String details) {
        super(String.format("Error while deleting plant: %s", details));
    }
}
