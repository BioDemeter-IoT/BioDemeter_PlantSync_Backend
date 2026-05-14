package com.plantsync.platform.plantprofiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * The type Plant id.
 */
@Embeddable
public record PlantId(Long value) {
  /**
   * Instantiates a new Plant id.
   *
   * @param value the value
   */
  public PlantId {
    if (value == null || value <= 0) {
      throw new IllegalArgumentException("Invalid plant id");
    }
  }
}
