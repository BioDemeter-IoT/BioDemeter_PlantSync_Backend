package com.plantsync.platform.plantprofiles.domain.services;

import com.plantsync.platform.plantprofiles.domain.model.aggregates.PlantHistory;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetAllPlantHistoriesByPlantIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantHistoryByIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantHistoryByPlantIdQuery;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for querying plant history.
 */
public interface PlantHistoryQueryService {

  /**
   * Handles querying plant history by plant ID.
   *
   * @param query The query.
   * @return The plant history.
   */
  Optional<PlantHistory> handle(GetPlantHistoryByPlantIdQuery query);

  /**
   * Handles querying plant history by record ID.
   *
   * @param query The query.
   * @return The plant history.
   */
  Optional<PlantHistory> handle(GetPlantHistoryByIdQuery query);

  /**
   * Handles querying all plant history records by plant ID.
   *
   * @param query The query.
   * @return A list of plant history records.
   */
  List<PlantHistory> handle(GetAllPlantHistoriesByPlantIdQuery query);
}
