package com.plantsync.platform.plantguides.application.internal.commandservices;

import com.plantsync.platform.plantguides.domain.exceptions.GuideCreationException;
import com.plantsync.platform.plantguides.domain.model.aggregates.Guide;
import com.plantsync.platform.plantguides.domain.model.commands.CreateGuideCommand;
import com.plantsync.platform.plantguides.domain.services.GuideCommandService;
import com.plantsync.platform.plantguides.infrastructure.persistence.jpa.repositories.GuideRepository;
import org.springframework.stereotype.Service;

/**
 * Service implementation for handling guide creation commands.
 * Responsible for persisting new guide entities into the system.
 */
@Service
public class GuideCommandServiceImpl implements GuideCommandService {

    private final GuideRepository guideRepository;

    /**
     * Constructor for the service.
     * @param guideRepository the repository used for persisting guide entities.
     */
    public GuideCommandServiceImpl(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    /**
     * Handles the creation of a new guide.
     * Converts the command into a guide entity and saves it to the database.
     *
     * @param command the command containing data for the new guide.
     * @return the ID of the newly created guide.
     * @throws GuideCreationException if any error occurs while saving the guide.
     */
    @Override
    public Long handle(CreateGuideCommand command) {
        var guide = new Guide(command);
        try {
            guideRepository.save(guide);
        } catch (Exception e) {
            throw new GuideCreationException(e.getMessage());
        }
        return guide.getId();
    }
}
