package com.dispatcher.service.controller;

import com.dispatcher.service.model.Country;
import com.dispatcher.service.service.CountryService;
import com.dispatcher.service.base.http.AbstractWebController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@Tag(name = "Countries", description = "API for managing business partners")
public class CountryController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    private final CountryService<Country> service;

    CountryController(CountryService<Country> service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get country by ID")
    public Country findById(@PathVariable Integer id,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        return service.findByPKey(id);
    }

    @GetMapping(path = "")
    @Operation(summary = "Get all countries")
    public List<Country> find(HttpServletRequest request,
                              HttpServletResponse response) {
        return service.findAll();
    }
}
