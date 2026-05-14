package com.plantsync.platform.tasks.domain.services;

import com.plantsync.platform.tasks.domain.model.aggregates.Task;
import com.plantsync.platform.tasks.domain.model.queries.GetAllTasksQuery;
import com.plantsync.platform.tasks.domain.model.queries.GetTaskByIdQuery;
import java.util.List;
import java.util.Optional;

/**
 * The interface Task query service.
 */
public interface TaskQueryService {

  /**
   * Handle list.
   *
   * @param query the query
   * @return the list
   */
  List<Task> handle(GetAllTasksQuery query);

  /**
   * Handle optional.
   *
   * @param query the query
   * @return the optional
   */
  Optional<Task> handle(GetTaskByIdQuery query);

}
