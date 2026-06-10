package com.plantsync.platform.analytics.infrastructure.persistence.jpa.entities;

import com.plantsync.platform.analytics.domain.model.valueobjects.NodeStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "AnalyticsIoTNode")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iot_nodes")
public class IoTNode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false, length = 20)
  private NodeStatus status;
}
