package com.plantsync.platform.tasks.interfaces.rest.resources;

public record TaskResource(

    Long id,
    String action,
    String date,
    Long plantId,
    Long profileId,
    Boolean completed

) {


}
