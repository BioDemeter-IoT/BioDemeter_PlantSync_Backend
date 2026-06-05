package com.plantsync.platform.analytics.interfaces.rest.resources;

public record DeviceStatusMetricsResource(
    Long onlineDevices,
    Long offlineDevices,
    Long errorDevices
) {
}
