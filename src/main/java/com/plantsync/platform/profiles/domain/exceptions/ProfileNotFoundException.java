package com.plantsync.platform.profiles.domain.exceptions;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(String message) {
        super("Error updating profile: " + message);
    }}
