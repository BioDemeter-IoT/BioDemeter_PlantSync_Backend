package com.plantsync.platform.analytics.infrastructure.persistence.jpa.repositories;

import com.plantsync.platform.analytics.infrastructure.persistence.jpa.entities.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsSensorReadingRepository extends JpaRepository<SensorReading, Long> {

  @Query("SELECT AVG(s.soilHumidity) FROM AnalyticsSensorReading s")
  Double findAverageSoilHumidity();

  @Query("SELECT AVG(s.airTemperature) FROM AnalyticsSensorReading s")
  Double findAverageAirTemperature();


}
