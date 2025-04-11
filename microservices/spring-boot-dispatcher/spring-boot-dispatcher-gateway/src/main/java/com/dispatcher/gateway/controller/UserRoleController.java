package com.dispatcher.gateway.controller;

import com.dispatcher.gateway.document.Application;
import com.dispatcher.gateway.model.Role;
import com.dispatcher.gateway.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users/{user-id}/role")
public class UserRoleController {

    private static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);

    private UserService service;

    public UserRoleController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Secured({"ROLE_admin"})
    public ResponseEntity<Application> assign(@RequestBody Role role) {
        Application result = new Application();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Secured({"ROLE_admin"})
    @DeleteMapping(value = "/{role-id}")
    public ResponseEntity<Application> remove(@PathVariable String roleId) {
        Application result = new Application();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
