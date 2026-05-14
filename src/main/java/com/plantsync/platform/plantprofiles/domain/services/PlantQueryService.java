package com.plantsync.platform.plantprofiles.domain.services;

import com.plantsync.platform.plantprofiles.domain.model.aggregates.Plant;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetAllPlantsByProfileIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetAllPlantsQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PlantQueryService {

    List<Plant> handle(GetAllPlantsQuery query);

    List<Plant> handle(GetAllPlantsByProfileIdQuery query);

    Optional<Plant> handle(GetPlantByIdQuery query);

}
