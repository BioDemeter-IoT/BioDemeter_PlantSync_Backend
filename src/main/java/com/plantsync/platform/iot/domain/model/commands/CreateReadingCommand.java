package com.plantsync.platform.iot.domain.model.commands;

public record CreateReadingCommand(Long nodeId, Float soilHumidity, Float airTemperature) {
}
