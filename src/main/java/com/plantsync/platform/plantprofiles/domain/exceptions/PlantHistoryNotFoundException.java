package com.plantsync.platform.plantprofiles.domain.exceptions;

/**
 * Exception thrown when plant history is not found for a given plant ID.
 */
public class PlantHistoryNotFoundException extends RuntimeException {

  /**
   * Constructs a new PlantHistoryNotFoundException with the specified plant ID.
   *
   * @param plantId The plant ID.
   */
  public PlantHistoryNotFoundException(Long plantId) {
    super(String.format("Plant history with plant ID %s not found.", plantId));
  }
}
