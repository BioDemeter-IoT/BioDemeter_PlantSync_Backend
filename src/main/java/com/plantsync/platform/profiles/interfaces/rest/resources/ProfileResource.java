package com.plantsync.platform.profiles.interfaces.rest.resources;

public record ProfileResource(

    Long id,
    String personName,
    String subscriptionPlan,
    Long userId) {
}
