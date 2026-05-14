package com.plantsync.platform.plantprofiles.application.internal.commandservices;


import com.plantsync.platform.plantprofiles.domain.model.aggregates.PlantHistory;
import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantHistoryCommand;
import com.plantsync.platform.plantprofiles.domain.services.PlantHistoryCommandService;
import com.plantsync.platform.plantprofiles.infrastructure.persistence.jpa.repositories.PlantHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class PlantHistoryCommandServiceImpl implements PlantHistoryCommandService {

    private final PlantHistoryRepository plantHistoryRepository;

    public PlantHistoryCommandServiceImpl(PlantHistoryRepository plantHistoryRepository) {

        this.plantHistoryRepository = plantHistoryRepository;
    }


    @Override
    public Long handle(CreatePlantHistoryCommand command) {
        var plantHistory = new PlantHistory(command);
        try {
            plantHistoryRepository.save(plantHistory);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving plant history: %s".formatted(e.getMessage()));
        }
        return plantHistory.getId();


    }
}