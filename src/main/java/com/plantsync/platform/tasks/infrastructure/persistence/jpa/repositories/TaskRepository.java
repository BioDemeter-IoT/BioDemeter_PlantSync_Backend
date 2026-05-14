package com.plantsync.platform.tasks.infrastructure.persistence.jpa.repositories;

import com.plantsync.platform.tasks.domain.model.aggregates.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Task repository.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
