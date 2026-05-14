package com.plantsync.platform.plantguides.domain.exceptions;

/**
 * The type Guide creation exception.
 */
public class GuideCreationException extends RuntimeException {
  /**
   * Instantiates a new Guide creation exception.
   *
   * @param details the details
   */
  public GuideCreationException(String details) {
    super(String.format("Error saving guide: %s", details));
  }
}

