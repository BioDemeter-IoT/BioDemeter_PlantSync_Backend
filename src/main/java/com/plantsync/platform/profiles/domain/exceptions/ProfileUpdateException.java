package com.plantsync.platform.profiles.domain.exceptions;

public class ProfileUpdateException extends RuntimeException {
    public ProfileUpdateException(String message) {
        super("Error updating profile: " + message);
    }
}
