package com.plantsync.platform.analytics.infrastructure.persistence.jpa.repositories;

import com.plantsync.platform.analytics.domain.model.valueobjects.NodeStatus;
import com.plantsync.platform.analytics.infrastructure.persistence.jpa.entities.IoTNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsIoTNodeRepository extends JpaRepository<IoTNode, Long> {

  long countByStatus(NodeStatus status);
}
