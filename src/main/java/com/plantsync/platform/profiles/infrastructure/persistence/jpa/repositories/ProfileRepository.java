package com.plantsync.platform.profiles.infrastructure.persistence.jpa.repositories;

import com.plantsync.platform.profiles.domain.model.aggregates.Profile;
import com.plantsync.platform.profiles.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * The interface Profile repository.
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

  /**
   * Find by user id optional.
   *
   * @param userId the user id
   * @return the optional
   */
  Optional<Profile> findByUserId(UserId userId);
}