package com.plantsync.platform.tasks.interfaces.rest.resources;

/**
 * The type Task resource.
 */
public record TaskResource(

    Long id,
    String action,
    String date,
    Long plantId,
    Long profileId,
    Boolean completed

) {


}
