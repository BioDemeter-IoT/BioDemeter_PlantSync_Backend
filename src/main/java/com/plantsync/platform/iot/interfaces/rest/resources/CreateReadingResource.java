package com.plantsync.platform.iot.interfaces.rest.resources;

public record CreateReadingResource(Long nodeId, Float soilHumidity, Float airTemperature) {
}
