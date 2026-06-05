package com.plantsync.platform.iot.application.internal.commandservices;

import com.plantsync.platform.iot.domain.model.aggregates.IoTNode;
import com.plantsync.platform.iot.domain.model.commands.CreateNodeCommand;
import com.plantsync.platform.iot.domain.services.IoTNodeCommandService;
import com.plantsync.platform.iot.infrastructure.persistence.jpa.repositories.IotNodeRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class IoTNodeCommandServiceImpl implements IoTNodeCommandService {

  private final IotNodeRepository iotNodeRepository;

  public IoTNodeCommandServiceImpl(IotNodeRepository iotNodeRepository) {
    this.iotNodeRepository = iotNodeRepository;
  }

  @Override
  public Optional<IoTNode> handle(CreateNodeCommand command) {
    if (iotNodeRepository.findByNodeCode(command.nodeCode()).isPresent()) {
      return Optional.empty();
    }
    var node = new IoTNode(command);
    var savedNode = iotNodeRepository.save(node);
    return Optional.of(savedNode);
  }
}
