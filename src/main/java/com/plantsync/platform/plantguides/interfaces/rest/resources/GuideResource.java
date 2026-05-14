package com.plantsync.platform.plantguides.interfaces.rest.resources;

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
