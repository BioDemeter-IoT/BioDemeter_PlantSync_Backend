package com.plantsync.platform.profiles.domain.model.commands;

public record UpdateProfileCommand(Long id, String personName, String subscriptionPlan) {
}
