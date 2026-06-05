package com.plantsync.platform.iot.domain.model.aggregates;

import com.plantsync.platform.iot.domain.model.commands.CreateNodeCommand;
import com.plantsync.platform.iot.domain.model.valueobjects.NodeStatus;
import com.plantsync.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.plantsync.platform.shared.domain.model.valueobjects.PlantId;
import com.plantsync.platform.shared.domain.model.valueobjects.ProfileId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "iot_nodes")
public class IoTNode extends AuditableAbstractAggregateRoot<IoTNode> {

  @Column(name = "node_code", nullable = false, unique = true)
  private String nodeCode;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false, length = 20)
  private NodeStatus status;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "plant_id"))
  private PlantId plantId;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "profile_id"))
  private ProfileId profileId;

  public IoTNode() {
  }

  public IoTNode(CreateNodeCommand command) {
    this.nodeCode = command.nodeCode();
    this.status = NodeStatus.ONLINE;
    this.plantId = command.plantId();
    this.profileId = command.profileId();
  }
}
