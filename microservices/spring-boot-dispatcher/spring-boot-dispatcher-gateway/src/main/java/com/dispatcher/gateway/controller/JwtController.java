/*
 * Version:  1.0.0
 *
 * Authors:  Kumar <Deebendu Kumar>
 */

package com.dispatcher.gateway.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/jwt")
@Tag(name = "JWT", description = "Controller for managing token-related operations")
public class JwtController {

    @GetMapping(path = "")
    @Operation(summary = "Find", tags = "Application")
    public Map<String, Object> findAll(@AuthenticationPrincipal Jwt jwt) {
        Map<String, Object> result = Collections.singletonMap("principal", jwt);
        return result;
    }
}
