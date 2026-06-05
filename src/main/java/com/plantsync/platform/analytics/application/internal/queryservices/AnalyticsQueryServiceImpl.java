package com.plantsync.platform.analytics.application.internal.queryservices;

import com.plantsync.platform.analytics.domain.model.queries.GetDeviceStatusMetricsQuery;
import com.plantsync.platform.analytics.domain.model.queries.GetGlobalTelemetryQuery;
import com.plantsync.platform.analytics.domain.model.valueobjects.DeviceStatusMetrics;
import com.plantsync.platform.analytics.domain.model.valueobjects.GlobalTelemetry;
import com.plantsync.platform.analytics.domain.model.valueobjects.NodeStatus;
import com.plantsync.platform.analytics.domain.services.AnalyticsQueryService;
import com.plantsync.platform.analytics.infrastructure.persistence.jpa.repositories.AnalyticsIoTNodeRepository;
import com.plantsync.platform.analytics.infrastructure.persistence.jpa.repositories.AnalyticsSensorReadingRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsQueryServiceImpl implements AnalyticsQueryService {

  private final AnalyticsSensorReadingRepository analyticsSensorReadingRepository;
  private final AnalyticsIoTNodeRepository analyticsIoTNodeRepository;

  public AnalyticsQueryServiceImpl(AnalyticsSensorReadingRepository analyticsSensorReadingRepository,
                                   AnalyticsIoTNodeRepository analyticsIoTNodeRepository) {
    this.analyticsSensorReadingRepository = analyticsSensorReadingRepository;
    this.analyticsIoTNodeRepository = analyticsIoTNodeRepository;
  }

  @Override
  public GlobalTelemetry handle(GetGlobalTelemetryQuery query) {
    var avgSoilHumidity = Optional.ofNullable(analyticsSensorReadingRepository.findAverageSoilHumidity())
        .orElse(0.0);
    var avgAirTemperature = Optional.ofNullable(analyticsSensorReadingRepository.findAverageAirTemperature())
        .orElse(0.0);
    return new GlobalTelemetry(avgSoilHumidity, avgAirTemperature);
  }

  @Override
  public DeviceStatusMetrics handle(GetDeviceStatusMetricsQuery query) {
    var onlineCount = analyticsIoTNodeRepository.countByStatus(NodeStatus.ONLINE);
    var offlineCount = analyticsIoTNodeRepository.countByStatus(NodeStatus.OFFLINE);
    var errorCount = analyticsIoTNodeRepository.countByStatus(NodeStatus.ERROR);
    return new DeviceStatusMetrics(onlineCount, offlineCount, errorCount);
  }
}
