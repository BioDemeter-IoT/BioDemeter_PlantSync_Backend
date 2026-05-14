package com.plantsync.platform.iam.domain.exceptions;

import com.plantsync.platform.iam.domain.model.valueobjects.Roles;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(Roles roleName) {
        super(String.format("Role with name '%s' not found.", roleName));
    }
}
