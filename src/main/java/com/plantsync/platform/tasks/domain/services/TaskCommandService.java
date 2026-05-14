package com.plantsync.platform.tasks.domain.services;

import com.plantsync.platform.tasks.domain.model.commands.CreateTaskCommand;
import com.plantsync.platform.tasks.domain.model.commands.DeleteTaskCommand;

/**
 * The interface Task command service.
 */
public interface TaskCommandService {

  /**
   * Handle long.
   *
   * @param command the command
   * @return the long
   */
  Long handle(CreateTaskCommand command);

  /**
   * Handle.
   *
   * @param command the command
   */
  void handle(DeleteTaskCommand command);

}

