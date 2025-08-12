package com.dispatcher.service.controller;

import com.dispatcher.service.service.WarehouseService;
import com.dispatcher.service.base.http.AbstractWebController;
import com.dispatcher.service.model.Warehouse;
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
@RequestMapping("/warehouses")
@Tag(name = "Warehouses", description = "API for manage warehouses")
public class WarehouseController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseController.class);

    private final WarehouseService<HashMap<String, Object>> service;

    WarehouseController(WarehouseService<HashMap<String, Object>> service) {
        this.service = service;
    }



    @GetMapping(path = "")
    @Operation(summary = "Get all warehouses")
    public List<HashMap<String, Object>> find(@RequestParam("name") Optional<String> code,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        return service.find(code);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get warehouse by ID")
    public HashMap<String, Object> findById(@PathVariable Integer id,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        return service.findByPKey(id);
    }
}
