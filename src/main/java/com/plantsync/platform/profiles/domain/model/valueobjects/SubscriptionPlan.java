package com.plantsync.platform.profiles.domain.model.valueobjects;

public enum SubscriptionPlan {
    BASIC,
    PREMIUM,
    PRO;

    public static SubscriptionPlan fromString(String value) {
        try {
            return SubscriptionPlan.valueOf(value.toUpperCase()); // ← clave
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid subscription plan: " + value);
        }
    }

}
