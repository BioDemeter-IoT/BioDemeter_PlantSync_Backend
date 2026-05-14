package com.plantsync.platform.iam.domain.model.commands;

import com.plantsync.platform.iam.domain.model.entities.Role;

import java.util.List;

/**
 * Sign up command.
 * <p>
 * This class represents the command to sign up a user.
 * </p>
 *
 * @param name             the name of the user
 * @param password         the password of the user
 * @param roles            the roles of the user
 * @param email            the email of the user
 * @param subscriptionPlan the subscription plan of the user
 */
public record SignUpCommand(String name, String password, List<Role> roles,
                            String email, String subscriptionPlan) {
}