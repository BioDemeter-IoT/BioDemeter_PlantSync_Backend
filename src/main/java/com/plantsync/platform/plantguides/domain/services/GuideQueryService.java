package com.plantsync.platform.plantguides.domain.services;

import com.plantsync.platform.plantguides.domain.model.aggregates.Guide;
import com.plantsync.platform.plantguides.domain.model.queries.GetAllGuidesQuery;
import com.plantsync.platform.plantguides.domain.model.queries.GetGuideByIdQuery;

import java.util.List;
import java.util.Optional;


/**
 * Service interface for handling query operations related to {@link Guide}.
 */
public interface GuideQueryService {

    /**
     * Retrieves all guides from the system.
     *
     * @param query the query object (empty in this case).
     * @return a list of all existing guides.
     */
    List<Guide> handle(GetAllGuidesQuery query);

    /**
     * Retrieves a specific guide by its ID.
     *
     * @param query the query object containing the guide ID.
     * @return an optional containing the guide if found, or empty if not found.
     */
    Optional<Guide> handle(GetGuideByIdQuery query);
}
