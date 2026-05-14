package com.plantsync.platform.profiles.domain.services;

import com.plantsync.platform.profiles.domain.model.aggregates.Profile;
import com.plantsync.platform.profiles.domain.model.queries.GetAllProfilesQuery;
import com.plantsync.platform.profiles.domain.model.queries.GetProfileByIdQuery;
import com.plantsync.platform.profiles.domain.model.queries.GetProfileByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
  /**
   * Handle Get Profile By ID Query.
   *
   * @param query The {@link GetProfileByIdQuery} Query
   * @return A {@link Profile} instance if the query is valid, otherwise empty
   */
  Optional<Profile> handle(GetProfileByIdQuery query);
  Optional<Profile> handle(GetProfileByUserIdQuery query);


  List<Profile> handle(GetAllProfilesQuery query);

}