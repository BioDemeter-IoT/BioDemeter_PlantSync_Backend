package com.plantsync.platform.analytics.interfaces.rest.resources;

public record GlobalTelemetryResource(
    Double averageSoilHumidity,
    Double averageTemperature,
    Double averageAirHumidity
) {
}
