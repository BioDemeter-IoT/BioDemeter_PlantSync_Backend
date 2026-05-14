package com.plantsync.platform.profiles.interfaces.rest.resources;

/**
 * The type Profile resource.
 */
public record ProfileResource(

    Long id,
    String personName,
    String subscriptionPlan,
    Long userId) {
}
