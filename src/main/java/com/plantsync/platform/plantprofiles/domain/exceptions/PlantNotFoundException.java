package com.plantsync.platform.plantprofiles.domain.exceptions;


public class PlantNotFoundException extends RuntimeException {
    public PlantNotFoundException(Long plantId) {
        super(String.format("Plant with ID %s not found.", plantId));
    }
}



