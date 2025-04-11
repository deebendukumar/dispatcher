package com.dispatcher.gateway.controller;

import com.dispatcher.gateway.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.RoleRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/roles")
@Tag(name = "Role", description = "Controller for managing role-related operations")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    private RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    @Operation(summary = "Find all roles", tags = "Role")
    public List<RoleRepresentation> findAll(@RequestParam("page") Optional<Integer> page,
                                            @RequestParam("size") Optional<Integer> size) {
        List<RoleRepresentation> list = service.findAll();
        return list;
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Find role with it's id", tags = "Role")
    public RoleRepresentation findById(@PathVariable String id) {
        RoleRepresentation roleRepresentation = service.findById(id);
        return roleRepresentation;
    }
}
