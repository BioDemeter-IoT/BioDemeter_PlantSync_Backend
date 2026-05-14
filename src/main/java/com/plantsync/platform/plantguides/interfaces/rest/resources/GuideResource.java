package com.plantsync.platform.plantguides.interfaces.rest.resources;

/**
 * Resource representing a guide.
 *
 * @param id          The unique identifier of the guide.
 * @param title       The title of the guide.
 * @param name        The name of the author.
 * @param description The description of the guide.
 * @param topic       The topic of the guide.
 * @param type        The type of the guide.
 * @param imageUrl    The image URL of the guide.
 */
public record GuideResource(
    Long id,
    String title,
    String name,
    String description,
    String topic,
    String type,
    String imageUrl
) {
}
