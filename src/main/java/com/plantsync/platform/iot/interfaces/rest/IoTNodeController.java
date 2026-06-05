package com.plantsync.platform.iot.interfaces.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.plantsync.platform.iot.domain.services.IoTNodeCommandService;
import com.plantsync.platform.iot.domain.services.IoTNodeQueryService;
import com.plantsync.platform.iot.interfaces.rest.assemblers.CreateNodeCommandFromResourceAssembler;
import com.plantsync.platform.iot.interfaces.rest.assemblers.IoTNodeResourceFromEntityAssembler;
import com.plantsync.platform.iot.interfaces.rest.resources.CreateNodeResource;
import com.plantsync.platform.iot.interfaces.rest.resources.IoTNodeResource;
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

@RestController
@RequestMapping(value = "/api/v1/iot/nodes", produces = APPLICATION_JSON_VALUE)
@Tag(name = "IoT Nodes", description = "IoT Node Management Endpoints")
public class IoTNodeController {

  private final IoTNodeCommandService iotNodeCommandService;
  private final IoTNodeQueryService iotNodeQueryService;

  public IoTNodeController(IoTNodeCommandService iotNodeCommandService,
                           IoTNodeQueryService iotNodeQueryService) {
    this.iotNodeCommandService = iotNodeCommandService;
    this.iotNodeQueryService = iotNodeQueryService;
  }

  @PostMapping
  @Operation(summary = "Register a new IoT node", description = "Register a new IoT node")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "IoT node created"),
      @ApiResponse(responseCode = "400", description = "Invalid input or duplicate node code")})
  public ResponseEntity<IoTNodeResource> createNode(@Valid @RequestBody CreateNodeResource resource) {
    var command = CreateNodeCommandFromResourceAssembler.toCommandFromResource(resource);
    var node = iotNodeCommandService.handle(command);
    if (node.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    var nodeEntity = node.get();
    var nodeResource = IoTNodeResourceFromEntityAssembler.toResourceFromEntity(nodeEntity);
    return new ResponseEntity<>(nodeResource, HttpStatus.CREATED);
  }
}
