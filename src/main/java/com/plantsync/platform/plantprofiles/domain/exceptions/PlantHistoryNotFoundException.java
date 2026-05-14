package com.plantsync.platform.plantprofiles.domain.exceptions;


public class PlantHistoryNotFoundException extends RuntimeException {
    public PlantHistoryNotFoundException(Long plantId) {
        super(String.format("Plant history with plant ID %s not found.", plantId));
    }
}



