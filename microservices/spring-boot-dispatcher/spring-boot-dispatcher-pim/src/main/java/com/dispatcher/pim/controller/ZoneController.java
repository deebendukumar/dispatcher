package com.dispatcher.pim.controller;

import com.dispatcher.pim.entity.Bin;
import com.dispatcher.pim.entity.Zone;
import com.dispatcher.pim.service.BinService;
import com.dispatcher.pim.service.ZoneService;
import com.dispatcher.service.base.http.AbstractWebController;
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
@RequestMapping("/zones")
@Tag(name = "Zones", description = "")
public class ZoneController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(ZoneController.class);

    private final ZoneService<Zone> service;

    ZoneController(ZoneService<Zone> service) {
        this.service = service;
    }

    @PostMapping(path = "")
    @Operation(summary = "")
    public Zone create(@RequestBody Zone zone,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        return service.create(zone);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "")
    public Zone find(@PathVariable String id,
                    HttpServletRequest request,
                    HttpServletResponse response) {
        return service.findByPKey(id);
    }

    @GetMapping(path = "")
    @Operation(summary = "")
    public List<Zone> findBy(@RequestParam("phone") Optional<String> phone,
                            @RequestParam("name") Optional<String> name,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        return service.findAll();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "")
    public Zone update(@PathVariable String id,
                          @RequestBody Zone zone,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.update(id, zone);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "")
    public Zone delete(@PathVariable String id,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.delete(id);
    }
}
