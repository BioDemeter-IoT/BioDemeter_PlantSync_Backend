package com.plantsync.platform.plantguides.interfaces.rest;

import com.plantsync.platform.plantguides.domain.model.queries.GetGuideByIdQuery;
import com.plantsync.platform.plantguides.domain.services.GuideCommandService;
import com.plantsync.platform.plantguides.domain.services.GuideQueryService;
import com.plantsync.platform.plantguides.interfaces.rest.assemblers.CreateGuideCommandFromResourceAssembler;
import com.plantsync.platform.plantguides.interfaces.rest.assemblers.GuideResourceFromEntityAssembler;
import com.plantsync.platform.plantguides.interfaces.rest.resources.CreateGuideResource;
import com.plantsync.platform.plantguides.interfaces.rest.resources.GuideResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * REST controller for handling HTTP requests related to  Guide creation.
 * Provides an endpoint to create a new guide.
 */
@RestController
@RequestMapping(value = "/api/v1/guides", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Guides", description = "Available Guide Endpoints")
public class GuideCommandController {


    private final GuideCommandService guideCommandService;
    private final GuideQueryService guideQueryService;


    public GuideCommandController(GuideCommandService guideCommandService, GuideQueryService guideQueryService) {
        this.guideCommandService = guideCommandService;
        this.guideQueryService = guideQueryService;

    }


    @PostMapping
    @Operation(summary = "Create a new guide", description = "Create a new guide")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Guide created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Guide not found")})
    public ResponseEntity<GuideResource> createGuide(@Valid @RequestBody CreateGuideResource resource) {
        var createGuideCommand = CreateGuideCommandFromResourceAssembler.toCommandFromResource(resource);
        var guideId = guideCommandService.handle(createGuideCommand);
        if (guideId == null || guideId == 0L) return ResponseEntity.badRequest().build();
        var getGuideByIdQuery = new GetGuideByIdQuery(guideId);
        var guide = guideQueryService.handle(getGuideByIdQuery);
        if (guide.isEmpty()) return ResponseEntity.notFound().build();
        var guideEntity = guide.get();
        var guideResource = GuideResourceFromEntityAssembler.toResourceFromEntity(guideEntity);
        return new ResponseEntity<>(guideResource, HttpStatus.CREATED);
    }



}
