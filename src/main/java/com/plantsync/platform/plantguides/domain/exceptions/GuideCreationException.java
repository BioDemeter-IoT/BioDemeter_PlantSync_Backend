package com.plantsync.platform.plantguides.domain.exceptions;

public class GuideCreationException extends RuntimeException {
    public GuideCreationException(String details) {
        super(String.format("Error saving guide: %s", details));
    }
}

