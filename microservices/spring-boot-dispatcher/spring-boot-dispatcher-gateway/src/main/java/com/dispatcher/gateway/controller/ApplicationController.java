package com.dispatcher.gateway.controller;

import com.dispatcher.gateway.document.Application;
import com.dispatcher.gateway.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.keycloak.representations.idm.ClientRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/applications")
@Tag(name = "Application", description = "Controller for managing application-related operations")
public class ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    private ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @PostMapping
    @Secured("ROLE_admin")
    @Operation(summary = "Create application", tags = "Application")
    public Application create(@RequestBody Application application) {
        Application result = null;
        logger.info(application.toJson());
        result = service.create(application);
        return result;
    }

    @GetMapping(path = "")
    @Secured({"ROLE_admin"})
    @Operation(summary = "Find all application", tags = "Application")
    public List<ClientRepresentation> findAll(@RequestParam("page") Optional<Integer> page,
                                              @RequestParam("size") Optional<Integer> size) {
        List<ClientRepresentation> list = service.findAll();
        return list;
    }

    @GetMapping(value = "/{id}")
    @Secured({"ROLE_admin"})
    @Operation(summary = "Find application with it's id", tags = "Application")
    public ClientRepresentation findById(@PathVariable String id) {
        ClientRepresentation result = service.findById(id);
        return result;
    }

    @PutMapping(path = "/{id}")
    @Secured("ROLE_admin")
    @Operation(summary = "Update application with it's id", tags = "Application")
    public Application update(@PathVariable String id,
                              @RequestBody Application application) {
        Application result = null;
        logger.info(application.toJson());
        result = service.update(id, application);
        return result;
    }

    @GetMapping(path = "/name")
    @Secured({"ROLE_admin"})
    @Operation(summary = "Find all application name", tags = "Application")
    public List<String> findAllName(@RequestParam("page") Optional<Integer> page,
                                    @RequestParam("size") Optional<Integer> size) {
        List<String> list = service.findAllApplicationName();
        return list;
    }
}
