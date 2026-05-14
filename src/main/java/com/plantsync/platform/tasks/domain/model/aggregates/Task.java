package com.plantsync.platform.tasks.domain.model.aggregates;

import com.plantsync.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.plantsync.platform.tasks.domain.model.commands.CreateTaskCommand;
import com.plantsync.platform.tasks.domain.model.valueobjects.PlantId;
import com.plantsync.platform.tasks.domain.model.valueobjects.ProfileId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * Task aggregate root.
 * Represents a task associated with a plant and a profile.
 */
@Getter
@Setter
@Entity
public class Task extends AuditableAbstractAggregateRoot<Task> {

  @NotNull
  private LocalDate date;

  @NotBlank
  private String action;

  @NotNull
  private Boolean completed;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "plant_id"))
  private PlantId plantId;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "profile_id"))
  private ProfileId profileId;

  /**
   * Default constructor for Task.
   */
  public Task() {
  }

  /**
   * Constructor for Task from CreateTaskCommand.
   *
   * @param command The {@link CreateTaskCommand} instance.
   */
  public Task(CreateTaskCommand command) {
    this.date = command.date();
    this.action = command.action();
    this.completed = command.completed();
    this.plantId = command.plantId();
    this.profileId = command.profileId();
  }

  /**
   * Updates the task information.
   *
   * @param newAction    The new action description.
   * @param newDate      The new date for the task.
   * @param newPlantId   The new {@link PlantId}.
   * @param newProfileId The new {@link ProfileId}.
   * @param newCompleted The new completion status.
   * @return The updated {@link Task} instance.
   */
  public Task updateInformation(
      String newAction,
      LocalDate newDate,
      PlantId newPlantId,
      ProfileId newProfileId,
      Boolean newCompleted
  ) {
    this.action = newAction;
    this.date = newDate;
    this.plantId = newPlantId;
    this.profileId = newProfileId;
    this.completed = newCompleted;

    return this;
  }

}