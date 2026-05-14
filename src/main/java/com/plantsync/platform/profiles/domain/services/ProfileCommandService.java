package com.plantsync.platform.profiles.domain.services;

import com.plantsync.platform.profiles.domain.model.aggregates.Profile;
import com.plantsync.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.plantsync.platform.profiles.domain.model.commands.UpdateProfileCommand;
import java.util.Optional;

/**
 * Service interface for handling profile-related commands.
 */
public interface ProfileCommandService {

  /**
   * Handle optional.
   *
   * @param command the command
   * @return the optional
   */
  Optional<Profile> handle(CreateProfileCommand command);

  /**
   * Handle optional.
   *
   * @param command the command
   * @return the optional
   */
  Optional<Profile> handle(UpdateProfileCommand command);
}
