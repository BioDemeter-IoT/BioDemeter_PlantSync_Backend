package com.plantsync.platform.plantprofiles.domain.model.aggregates;

import com.plantsync.platform.plantprofiles.domain.model.commands.CreatePlantHistoryCommand;
import com.plantsync.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.PlantId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Aggregate root representing a historical record of plant care or sensor data.
 * Tracks actions such as watering, fertilizing, and humidity changes over time.
 */
@Getter
@Setter
@Entity
public class PlantHistory extends AuditableAbstractAggregateRoot<PlantHistory> {

    /**
     * The ID of the plant associated with this history record.
     */
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "plant_id"))
    private PlantId plantId;

    /**
     * The type of action or event recorded (e.g., "WATERED", "FERTILIZED",
     * "SENSOR_READING").
     */
    private String type;

    /**
     * The date the action or reading occurred.
     */
    private LocalDate date;

    /**
     * The time the action or reading occurred.
     */
    private LocalTime time;

    /**
     * The humidity level recorded at that time, if applicable.
     */
    private Integer humidity;

    /**
     * Default constructor required by JPA.
     */
    public PlantHistory() {
        super();
    }

    /**
     * Constructs a new {@link PlantHistory} record based on the given command.
     *
     * @param command the command containing all necessary information to create the
     *                record
     */
    public PlantHistory(CreatePlantHistoryCommand command) {
        this.plantId = command.plantId();
        this.type = command.type();
        this.date = command.date();
        this.time = command.time();
        this.humidity = command.humidity();
    }
}
