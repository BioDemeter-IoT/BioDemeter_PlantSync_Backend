package com.plantsync.platform.plantguides.domain.model.queries;

/**
 * Query object used to retrieve a specific Guide by its ID.
 *
 * @param guideId the unique identifier of the guide to retrieve, must be greater than 0.
 */
public record GetGuideByIdQuery(Long guideId) {

    /**
     * Compact constructor to validate the guide ID.
     */
    public GetGuideByIdQuery {
        if (guideId == null || guideId <= 0) {
            throw new IllegalArgumentException("Guide id is required.");
        }
    }
}
