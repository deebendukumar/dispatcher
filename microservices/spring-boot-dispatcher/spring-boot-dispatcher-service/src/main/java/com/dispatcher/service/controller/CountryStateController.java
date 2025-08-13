package com.dispatcher.service.controller;

import com.dispatcher.common.base.AbstractWebController;
import com.dispatcher.service.service.impl.CountryStateApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/states")
@Tag(name = "States", description = "API for managing business partners")
public class CountryStateController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(CountryStateController.class);

    private final CountryStateApiService service;

    CountryStateController(CountryStateApiService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    @Operation(summary = "Get all states of a country")
    public List<HashMap<String, Object>> find(HttpServletRequest request,
                                              HttpServletResponse response) {
        return service.findAll();
    }
}
