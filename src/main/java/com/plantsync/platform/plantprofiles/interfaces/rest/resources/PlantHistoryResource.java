package com.plantsync.platform.plantprofiles.interfaces.rest.resources;

/**
 * The type Plant history resource.
 */
public record PlantHistoryResource(
    Long id,
    Long plantId,
    String type,
    String date,
    String time,
    Integer humidity


) {
}
