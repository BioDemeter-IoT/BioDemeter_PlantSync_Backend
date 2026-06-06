package com.plantsync.platform.iot.domain.model.entities;

import com.plantsync.platform.iot.domain.model.commands.CreateReadingCommand;
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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sensor_readings")
public class SensorReading {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "node_id", nullable = false)
  private Long nodeId;

  @Column(name = "soil_humidity")
  private Float soilHumidity;

  @Column(name = "air_temperature")
  private Float airTemperature;

  @Column(name = "timestamp", nullable = false)
  private LocalDateTime timestamp;

  public SensorReading(CreateReadingCommand command) {
    this.nodeId = command.nodeId();
    this.soilHumidity = command.soilHumidity();
    this.airTemperature = command.airTemperature();
    this.timestamp = LocalDateTime.now();
  }
}
