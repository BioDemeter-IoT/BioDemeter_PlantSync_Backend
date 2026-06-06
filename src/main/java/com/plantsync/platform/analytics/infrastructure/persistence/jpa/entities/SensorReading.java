package com.plantsync.platform.analytics.infrastructure.persistence.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "AnalyticsSensorReading")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sensor_readings")
public class SensorReading {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "soil_humidity")
  private Double soilHumidity;

  @Column(name = "air_temperature")
  private Double airTemperature;



  @Column(name = "recorded_at")
  private LocalDateTime recordedAt;

  @Column(name = "node_id")
  private Long nodeId;
}
