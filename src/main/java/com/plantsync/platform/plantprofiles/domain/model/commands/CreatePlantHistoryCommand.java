package com.plantsync.platform.plantprofiles.domain.model.commands;

import com.plantsync.platform.plantprofiles.domain.model.valueobjects.PlantId;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Plant History Command.
 * */
public record CreatePlantHistoryCommand(


    PlantId plantId,

    String type,
    LocalDate date,
    LocalTime time,
    Integer humidity
) {
}
