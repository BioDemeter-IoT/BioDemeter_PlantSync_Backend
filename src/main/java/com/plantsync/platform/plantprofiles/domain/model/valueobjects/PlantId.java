package com.plantsync.platform.plantprofiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PlantId(Long value) {
    public PlantId {
        if (value == null || value <= 0) throw new IllegalArgumentException("Invalid plant id");
    }
}
