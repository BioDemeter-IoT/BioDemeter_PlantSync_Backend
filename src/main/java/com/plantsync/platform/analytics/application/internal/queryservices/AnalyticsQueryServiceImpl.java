package com.plantsync.platform.analytics.application.internal.queryservices;

import com.plantsync.platform.analytics.domain.model.queries.GetDeviceStatusMetricsQuery;
import com.plantsync.platform.analytics.domain.model.queries.GetGlobalTelemetryQuery;
import com.plantsync.platform.analytics.domain.model.valueobjects.DeviceStatusMetrics;
import com.plantsync.platform.analytics.domain.model.valueobjects.GlobalTelemetry;
import com.plantsync.platform.analytics.domain.model.valueobjects.NodeStatus;
import com.plantsync.platform.analytics.domain.services.AnalyticsQueryService;
import com.plantsync.platform.analytics.infrastructure.persistence.jpa.repositories.IoTNodeRepository;
import com.plantsync.platform.analytics.infrastructure.persistence.jpa.repositories.SensorReadingRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsQueryServiceImpl implements AnalyticsQueryService {

  private final SensorReadingRepository sensorReadingRepository;
  private final IoTNodeRepository iotNodeRepository;

  public AnalyticsQueryServiceImpl(SensorReadingRepository sensorReadingRepository,
                                   IoTNodeRepository iotNodeRepository) {
    this.sensorReadingRepository = sensorReadingRepository;
    this.iotNodeRepository = iotNodeRepository;
  }

  @Override
  public GlobalTelemetry handle(GetGlobalTelemetryQuery query) {
    var avgSoilHumidity = Optional.ofNullable(sensorReadingRepository.findAverageSoilHumidity())
        .orElse(0.0);
    var avgAirTemperature = Optional.ofNullable(sensorReadingRepository.findAverageAirTemperature())
        .orElse(0.0);
    var avgAirHumidity = Optional.ofNullable(sensorReadingRepository.findAverageAirHumidity())
        .orElse(0.0);
    return new GlobalTelemetry(avgSoilHumidity, avgAirTemperature, avgAirHumidity);
  }

  @Override
  public DeviceStatusMetrics handle(GetDeviceStatusMetricsQuery query) {
    var onlineCount = iotNodeRepository.countByStatus(NodeStatus.ONLINE);
    var offlineCount = iotNodeRepository.countByStatus(NodeStatus.OFFLINE);
    var errorCount = iotNodeRepository.countByStatus(NodeStatus.ERROR);
    return new DeviceStatusMetrics(onlineCount, offlineCount, errorCount);
  }
}
