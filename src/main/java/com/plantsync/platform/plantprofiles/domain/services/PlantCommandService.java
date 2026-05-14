package com.plantsync.platform.plantprofiles.domain.services;

import com.plantsync.platform.plantprofiles.domain.model.aggregates.Plant;
import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantCommand;
import com.plantsync.platform.plantprofiles.domain.model.commands.DeletePlantCommand;
import com.plantsync.platform.plantprofiles.domain.model.commands.UpdatePlantCommand;

import java.util.Optional;

public interface PlantCommandService {




        Long handle(CreatePlantCommand command);

        void handle(DeletePlantCommand command);

        Optional<Plant> handle(UpdatePlantCommand command);


}
