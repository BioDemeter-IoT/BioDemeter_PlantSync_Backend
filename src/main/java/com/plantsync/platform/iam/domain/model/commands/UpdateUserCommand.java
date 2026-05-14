package com.plantsync.platform.iam.domain.model.commands;

public record UpdateUserCommand(
    Long id,
    String email
) {
}
