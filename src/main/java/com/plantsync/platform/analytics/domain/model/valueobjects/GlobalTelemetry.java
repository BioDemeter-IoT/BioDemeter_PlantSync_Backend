package com.plantsync.platform.analytics.domain.model.valueobjects;

public record GlobalTelemetry(
    Double averageSoilHumidity,
    Double averageTemperature,
    Double averageAirHumidity
) {
}
