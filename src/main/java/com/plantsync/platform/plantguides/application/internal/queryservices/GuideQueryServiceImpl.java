package com.plantsync.platform.plantguides.application.internal.queryservices;

import com.plantsync.platform.plantguides.domain.model.queries.GetAllGuidesQuery;
import com.plantsync.platform.plantguides.domain.model.queries.GetGuideByIdQuery;
import com.plantsync.platform.plantguides.domain.services.GuideQueryService;
import com.plantsync.platform.plantguides.infrastructure.persistence.jpa.repositories.GuideRepository;
import com.plantsync.platform.plantguides.domain.model.aggregates.Guide;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

/**
 * Service implementation for handling guide-related queries.
 * Provides methods for retrieving all guides or a guide by its ID.
 */
@Service
public class GuideQueryServiceImpl implements GuideQueryService {

    private final GuideRepository guideRepository;

    /**
     * Constructor for the query service.
     *
     * @param guideRepository the repository used to query guide entities.
     */
    public GuideQueryServiceImpl(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    /**
     * Handles the retrieval of all guides in the system.
     *
     * @param query the query object for getting all guides (typically empty).
     * @return a list of all existing {@link Guide} entities.
     */
    @Override
    public List<Guide> handle(GetAllGuidesQuery query) {
        return guideRepository.findAll();
    }

    /**
     * Handles the retrieval of a guide by its ID.
     *
     * @param query the query object containing the guide ID.
     * @return an {@link Optional} containing the guide if found, or empty if not found.
     */
    @Override
    public Optional<Guide> handle(GetGuideByIdQuery query) {
        return guideRepository.findById(query.guideId());
    }
}
