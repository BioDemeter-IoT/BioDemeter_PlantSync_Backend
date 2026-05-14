package com.plantsync.platform.plantprofiles.domain.services;

import com.plantsync.platform.plantprofiles.domain.model.aggregates.PlantHistory;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetAllPlantHistoriesByPlantIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantHistoryByIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantHistoryByPlantIdQuery;

import java.util.List;
import java.util.Optional;

public interface PlantHistoryQueryService {

    Optional<PlantHistory> handle(GetPlantHistoryByPlantIdQuery query);

    Optional<PlantHistory> handle(GetPlantHistoryByIdQuery query);

    List<PlantHistory> handle(GetAllPlantHistoriesByPlantIdQuery query);

}
