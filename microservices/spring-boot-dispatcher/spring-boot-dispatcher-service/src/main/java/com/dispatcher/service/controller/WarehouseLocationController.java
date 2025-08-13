package com.dispatcher.service.controller;

import com.dispatcher.common.base.AbstractWebController;
import com.dispatcher.odoo.facade.WarehouseLocationApiClient;
import com.dispatcher.service.service.impl.WarehouseApiService;
import com.dispatcher.service.service.impl.WarehouseLocationApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/warehouses/locations")
@Tag(name = "Warehouse Locations", description = "API for manage warehouse locations")
public class WarehouseLocationController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseLocationController.class);

    private final WarehouseLocationApiService service;

    WarehouseLocationController(WarehouseLocationApiService service) {
        this.service = service;
    }



    @GetMapping(path = "")
    @Operation(summary = "Get all warehouse locations")
    public List<HashMap<String, Object>> find(@RequestParam("name") Optional<String> code,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get warehouse location by ID")
    public HashMap<String, Object> findById(@PathVariable Integer id,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        return service.findByPKey(id);
    }
}
