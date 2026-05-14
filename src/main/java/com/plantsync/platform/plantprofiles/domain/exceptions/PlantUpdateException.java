package com.plantsync.platform.plantprofiles.domain.exceptions;

public class PlantUpdateException extends RuntimeException {
    public PlantUpdateException(String details) {
        super(String.format("Error while updating plant: %s", details));
    }
}
