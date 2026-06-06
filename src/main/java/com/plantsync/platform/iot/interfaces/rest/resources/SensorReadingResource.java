package com.plantsync.platform.iot.interfaces.rest.resources;

public record SensorReadingResource(
    Long id,
    Long nodeId,
    Float soilHumidity,
    Float airTemperature,
    String timestamp
) {
}
