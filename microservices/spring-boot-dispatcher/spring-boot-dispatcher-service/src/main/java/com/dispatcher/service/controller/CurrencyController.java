package com.dispatcher.service.controller;

import com.dispatcher.common.base.AbstractWebController;
import com.dispatcher.service.service.impl.CurrencyApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/currencies")
@Tag(name = "Currencies", description = "API for managing currencies")
public class CurrencyController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);

    private final CurrencyApiService service;

    CurrencyController(CurrencyApiService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    @Operation(summary = "Get all currencies")
    public List<HashMap<String, Object>> find(HttpServletRequest request,
                                              HttpServletResponse response) {
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get partner by ID")
    public HashMap<String, Object> findById(@PathVariable Integer id,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
        return service.findByPKey(id);
    }
}
