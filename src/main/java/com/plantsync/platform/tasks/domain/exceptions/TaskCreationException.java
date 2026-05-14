package com.plantsync.platform.tasks.domain.exceptions;

public class TaskCreationException extends RuntimeException {
    public TaskCreationException(String details) {
        super(String.format("Error saving task: %s", details));
    }
}
