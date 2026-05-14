package com.plantsync.platform.plantprofiles.domain.exceptions;

public class PlantCreationException extends RuntimeException {
    public PlantCreationException(String details) {
        super(String.format("Error saving plant: %s", details));
    }
}