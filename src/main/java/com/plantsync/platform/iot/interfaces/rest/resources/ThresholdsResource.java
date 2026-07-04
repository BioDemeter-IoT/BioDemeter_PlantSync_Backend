package com.plantsync.platform.iot.interfaces.rest.resources;

public record ThresholdsResource(
    Boolean linked,
    Float temperatureThresholdMin,
    Float temperatureThresholdMax,
    Float lightThresholdMin,
    Float lightThresholdMax
) {
}
