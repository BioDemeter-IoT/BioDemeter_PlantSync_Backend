package com.plantsync.platform.profiles.domain.exceptions;

/**
 * The type Profile not found exception.
 */
public class ProfileNotFoundException extends RuntimeException {
  /**
   * Instantiates a new Profile not found exception.
   *
   * @param message the message
   */
  public ProfileNotFoundException(String message) {
    super("Error updating profile: " + message);
  }
}
