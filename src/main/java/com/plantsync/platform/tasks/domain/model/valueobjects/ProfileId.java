package com.plantsync.platform.tasks.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * The type Profile id.
 */
@Embeddable
public record ProfileId(Long value) {
  /**
   * Instantiates a new Profile id.
   *
   * @param value the value
   */
  public ProfileId {
    if (value == null || value <= 0) {
      throw new IllegalArgumentException("Invalid profile id");
    }
  }
}
