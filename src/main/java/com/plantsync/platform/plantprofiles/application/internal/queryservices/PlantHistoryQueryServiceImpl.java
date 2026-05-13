package com.plantsync.platform.plantprofiles.application.internal.queryservices;

import com.plantsync.platform.plantprofiles.domain.model.aggregates.PlantHistory;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetAllPlantHistoriesByPlantIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantHistoryByIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantHistoryByPlantIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.PlantId;
import com.plantsync.platform.plantprofiles.domain.services.PlantHistoryQueryService;
import com.plantsync.platform.plantprofiles.infrastructure.persistence.jpa.repositories.PlantHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PlantHistoryQueryServiceImpl implements PlantHistoryQueryService {

    private final PlantHistoryRepository plantHistoryRepository;

    public PlantHistoryQueryServiceImpl(PlantHistoryRepository plantHistoryRepository) {
        this.plantHistoryRepository = plantHistoryRepository;
    }


    @Override
    public Optional<PlantHistory> handle(GetPlantHistoryByPlantIdQuery query) {

        return plantHistoryRepository.findFirstByPlantId(new PlantId(query.plantId()));
    }
    @Override
    public Optional<PlantHistory> handle(GetPlantHistoryByIdQuery query) {
        return plantHistoryRepository.findById(query.id());
    }
    @Override
    public List<PlantHistory> handle(GetAllPlantHistoriesByPlantIdQuery query) {
        return plantHistoryRepository.findByPlantId(query.plantId());
    }


}
