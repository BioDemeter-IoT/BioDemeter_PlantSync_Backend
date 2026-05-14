package com.plantsync.platform.plantprofiles.domain.model.queries;

import com.plantsync.platform.plantprofiles.domain.model.valueobjects.PlantId;

/**
 * The type Get all plant histories by plant id query.
 */
public record GetAllPlantHistoriesByPlantIdQuery(PlantId plantId) {
}
