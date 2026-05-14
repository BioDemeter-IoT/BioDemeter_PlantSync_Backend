package com.plantsync.platform.profiles.domain.model.valueobjects;


public record PersonName(String name) {



    public PersonName {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be null or blank");
        }
    }
}