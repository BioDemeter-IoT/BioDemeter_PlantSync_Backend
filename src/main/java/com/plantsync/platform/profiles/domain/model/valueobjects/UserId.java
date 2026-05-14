package com.plantsync.platform.profiles.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record UserId(Long value) {
    public UserId {
        if (value == null || value <= 0) throw new IllegalArgumentException("Invalid profile id");
    }
}
