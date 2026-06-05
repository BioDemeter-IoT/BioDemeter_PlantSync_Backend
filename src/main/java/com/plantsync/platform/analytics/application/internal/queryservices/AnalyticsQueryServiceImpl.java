package com.plantsync.platform.analytics.application.internal.queryservices;

import com.plantsync.platform.analytics.domain.model.queries.GetDeviceStatusMetricsQuery;
import com.plantsync.platform.analytics.domain.model.queries.GetGlobalTelemetryQuery;
import com.plantsync.platform.analytics.domain.model.valueobjects.DeviceStatusMetrics;
import com.plantsync.platform.analytics.domain.model.valueobjects.GlobalTelemetry;
import com.plantsync.platform.analytics.domain.services.AnalyticsQueryService;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsQueryServiceImpl implements AnalyticsQueryService {

  @Override
  public GlobalTelemetry handle(GetGlobalTelemetryQuery query) {
    return new GlobalTelemetry(42.5, 23.8, 65.2);
  }

  @Override
  public DeviceStatusMetrics handle(GetDeviceStatusMetricsQuery query) {
    return new DeviceStatusMetrics(15L, 3L, 1L);
  }
}
