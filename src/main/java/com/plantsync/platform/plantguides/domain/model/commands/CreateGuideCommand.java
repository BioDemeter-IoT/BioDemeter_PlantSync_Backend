package com.plantsync.platform.plantguides.domain.model.commands;

/**
 * Command object used to encapsulate the data required to create a new Guide.
 * Performs basic validation in the compact constructor.
 *
 * @param title       the title of the guide, must not be null or blank.
 * @param name        the name of the author or creator of the guide.
 * @param description the description of the guide, must not be null or blank.
 * @param topic       the topic or category of the guide.
 * @param type        the type of guide (e.g., article, tutorial).
 * @param imageUrl    the URL of the guide's image.
 */
public record CreateGuideCommand(

        String title,
        String name,
        String description,
        String topic,
        String type,
        String imageUrl

) {
    /**
     * Compact constructor with validation for required fields.
     *
     * @throws IllegalArgumentException if title or description are null or blank.
     */
    public CreateGuideCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("description cannot be null or blank");
        }
    }
}
