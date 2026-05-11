package com.plantsync.platform.plantprofiles.interfaces.rest;

import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantByIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantHistoryByIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantHistoryByPlantIdQuery;
import com.plantsync.platform.plantprofiles.domain.services.PlantHistoryCommandService;
import com.plantsync.platform.plantprofiles.domain.services.PlantHistoryQueryService;
import com.plantsync.platform.plantprofiles.interfaces.rest.assemblers.CreatePlantHistoryCommandFromResourceAssembler;
import com.plantsync.platform.plantprofiles.interfaces.rest.assemblers.PlantHistoryResourceFromEntityAssembler;
import com.plantsync.platform.plantprofiles.interfaces.rest.assemblers.PlantResourceFromEntityAssembler;
import com.plantsync.platform.plantprofiles.interfaces.rest.resources.CreatePlantHistoryResource;
import com.plantsync.platform.plantprofiles.interfaces.rest.resources.PlantHistoryResource;
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


@RestController
@RequestMapping(value = "/api/v1/plantHistories", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Plant Histories", description = "Available Plant Histories Endpoints")
public class PlantHistoryCommandController {

    private final PlantHistoryCommandService plantHistoryCommandService;
    private final PlantHistoryQueryService plantHistoryQueryService;


    public PlantHistoryCommandController(PlantHistoryCommandService plantHistoryCommandService, PlantHistoryQueryService plantHistoryQueryService) {
        this.plantHistoryCommandService = plantHistoryCommandService;
        this.plantHistoryQueryService = plantHistoryQueryService;

    }

    @PostMapping
    @Operation(summary = "Create a new plant history", description = "Create a new plant history")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plant created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Plant not found")})
    public ResponseEntity<PlantHistoryResource> createPlantHistory(@Valid @RequestBody CreatePlantHistoryResource resource) {
        var createPlantHistoryCommand = CreatePlantHistoryCommandFromResourceAssembler.toCommandFromResource(resource);
        var plantHistoryId = plantHistoryCommandService.handle(createPlantHistoryCommand);
        if (plantHistoryId == null || plantHistoryId == 0L) return ResponseEntity.badRequest().build();


        var getPlantHistoryByIdQuery = new GetPlantHistoryByIdQuery(plantHistoryId);
        var plantHistory = plantHistoryQueryService.handle(getPlantHistoryByIdQuery);
        if (plantHistory.isEmpty()) return ResponseEntity.notFound().build();
        var plantHistoryResource = PlantHistoryResourceFromEntityAssembler.toResourceFromEntity(plantHistory.get());
        return new ResponseEntity<>(plantHistoryResource, HttpStatus.CREATED);
    }


}
