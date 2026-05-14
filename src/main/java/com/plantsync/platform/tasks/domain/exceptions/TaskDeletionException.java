package com.plantsync.platform.tasks.domain.exceptions;

public class TaskDeletionException extends RuntimeException {
    public TaskDeletionException(String details) {
        super(String.format("Error while deleting task: %s", details));
    }
}
