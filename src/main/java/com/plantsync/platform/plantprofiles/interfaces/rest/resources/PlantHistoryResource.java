package com.plantsync.platform.plantprofiles.interfaces.rest.resources;

public record PlantHistoryResource(
    Long id,
    Long plantId,
    String type,
    String date,
    String time,
    Integer humidity


) {
}
