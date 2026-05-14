package com.plantsync.platform.profiles.interfaces.acl;

/**
 * ProfilesContextFacade.
 */
public interface ProfilesContextFacade {

  Long createProfile(String name, Long userId, String subscriptionPlan);


}