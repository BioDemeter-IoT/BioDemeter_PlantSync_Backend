package com.plantsync.platform.plantguides.domain.model.aggregates;

import com.plantsync.platform.plantguides.domain.model.commands.CreateGuideCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.plantsync.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

/**
 * Entity that represents a guide in the system.
 * A guide contains information such as title, author name, description, topic, type, and an associated image URL.
 */
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Guide extends AuditableAbstractAggregateRoot<Guide> {

  /**
   * Title of the guide.
   * Must not be blank and limited to 100 characters.
   */
  @NotBlank
  @Size(max = 100)
  private String title;

  /**
   * Name of the author or creator of the guide.
   * Must not be blank and limited to 100 characters.
   */
  @NotBlank
  @Size(max = 100)
  private String name;

  /**
   * Description of the guide content.
   * Must not be blank and limited to 1000 characters.
   */
  @NotBlank
  @Size(max = 1000)
  private String description;

  /**
   * Topic or category the guide belongs to.
   * Must not be blank and limited to 50 characters.
   */
  @NotBlank
  @Size(max = 50)
  private String topic;

  /**
   * Type of the guide (e.g., tutorial, article, manual).
   * Must not be blank and limited to 50 characters.
   */
  @NotBlank
  @Size(max = 50)
  private String type;

  /**
   * URL of the image representing the guide.
   * Must not be blank and limited to 255 characters.
   */
  @NotBlank
  @Size(max = 255)
  private String imageUrl;

  /**
   * Default constructor for JPA.
   */
  public Guide() {
  }

  /**
   * Constructor to create a guide with all fields.
   *
   * @param title       the title of the guide
   * @param name        the author's name
   * @param description the guide's content description
   * @param topic       the topic or category
   * @param type        the type of guide
   * @param imageUrl    the image URL
   */
  public Guide(String title, String name, String description, String topic, String type, String imageUrl) {
    this.title = title;
    this.name = name;
    this.description = description;
    this.topic = topic;
    this.type = type;
    this.imageUrl = imageUrl;
  }

  /**
   * Constructor that builds a guide entity from a {@link CreateGuideCommand}.
   *
   * @param command the command containing all the necessary data to create a guide.
   */
  public Guide(CreateGuideCommand command) {
    this.title = command.title();
    this.name = command.name();
    this.description = command.description();
    this.topic = command.topic();
    this.type = command.type();
    this.imageUrl = command.imageUrl();
  }
}
