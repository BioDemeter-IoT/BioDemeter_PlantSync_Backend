package com.plantsync.platform.plantguides.domain.services;

import com.plantsync.platform.plantguides.domain.model.commands.CreateGuideCommand;

/**
 * Service interface for handling command operations related to  Guide.
 */
public interface GuideCommandService {

    /**
     * Handles the creation of a new guide.
     *
     * @param command the command object containing the data for the new guide.
     * @return the ID of the created guide.
     */
    Long handle(CreateGuideCommand command);
}
