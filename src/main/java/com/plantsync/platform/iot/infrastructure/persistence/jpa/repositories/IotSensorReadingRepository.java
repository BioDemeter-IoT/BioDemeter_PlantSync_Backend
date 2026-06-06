package com.plantsync.platform.iot.infrastructure.persistence.jpa.repositories;

import com.plantsync.platform.iot.domain.model.entities.SensorReading;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IotSensorReadingRepository extends JpaRepository<SensorReading, Long> {

  List<SensorReading> findByNodeIdAndTimestampBetween(Long nodeId, LocalDateTime start, LocalDateTime end);
}
