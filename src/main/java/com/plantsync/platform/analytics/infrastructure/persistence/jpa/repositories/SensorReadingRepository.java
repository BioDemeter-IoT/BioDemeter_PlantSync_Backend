package com.plantsync.platform.analytics.infrastructure.persistence.jpa.repositories;

import com.plantsync.platform.analytics.infrastructure.persistence.jpa.entities.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {

  @Query("SELECT AVG(s.soilHumidity) FROM SensorReading s")
  Double findAverageSoilHumidity();

  @Query("SELECT AVG(s.airTemperature) FROM SensorReading s")
  Double findAverageAirTemperature();

  @Query("SELECT AVG(s.airHumidity) FROM SensorReading s")
  Double findAverageAirHumidity();
}
