package com.dispatcher.pim.controller;

import com.dispatcher.common.base.AbstractWebController;
import com.dispatcher.pim.entity.Warehouse;
import com.dispatcher.pim.service.WarehouseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/warehouses")
@Tag(name = "Warehouses", description = "")
public class WarehouseController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseController.class);

    private final WarehouseService<Warehouse> service;

    WarehouseController(WarehouseService<Warehouse> service) {
        this.service = service;
    }

    @PostMapping(path = "")
    @Operation(summary = "")
    public Warehouse create(@RequestBody Warehouse warehouse,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        return service.create(warehouse);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "")
    public Warehouse find(@PathVariable String id,
                    HttpServletRequest request,
                    HttpServletResponse response) {
        return service.findByPKey(id);
    }

    @GetMapping(path = "")
    @Operation(summary = "")
    public List<Warehouse> findBy(@RequestParam("phone") Optional<String> phone,
                            @RequestParam("name") Optional<String> name,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        return service.findAll();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "")
    public Warehouse update(@PathVariable String id,
                          @RequestBody Warehouse warehouse,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.update(id, warehouse);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "")
    public Warehouse delete(@PathVariable String id,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.delete(id);
    }
}
