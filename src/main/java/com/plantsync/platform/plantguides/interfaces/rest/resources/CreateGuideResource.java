package com.plantsync.platform.plantguides.interfaces.rest.resources;

public record CreateGuideResource(

        String title,
        String name,
        String description,
        String topic,
        String type,
        String imageUrl

) {

    public CreateGuideResource{

    if (title.isBlank() || title == null) throw new IllegalArgumentException();
    if (name.isBlank() || name == null) throw new IllegalArgumentException();
    if (description.isBlank() || description == null) throw new IllegalArgumentException();
    if (topic.isBlank() || topic == null) throw new IllegalArgumentException();
    if (type.isBlank() || type == null) throw new IllegalArgumentException();
    if (imageUrl.isBlank() || imageUrl == null) throw new IllegalArgumentException();

    }
}
