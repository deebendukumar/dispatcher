package com.dispatcher.pim.controller;

import com.dispatcher.common.base.AbstractWebController;
import com.dispatcher.pim.entity.Hazmat;
import com.dispatcher.pim.service.HazmatService;
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
@RequestMapping("/hazmat")
@Tag(name = "Hazmat", description = "")
public class HazmatController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(HazmatController.class);

    private final HazmatService<Hazmat> service;

    HazmatController(HazmatService<Hazmat> service) {
        this.service = service;
    }

    @PostMapping(path = "")
    @Operation(summary = "")
    public Hazmat create(@RequestBody Hazmat hazmat,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        return service.create(hazmat);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "")
    public Hazmat find(@PathVariable String id,
                    HttpServletRequest request,
                    HttpServletResponse response) {
        return service.findByPKey(id);
    }

    @GetMapping(path = "")
    @Operation(summary = "")
    public List<Hazmat> findBy(@RequestParam("phone") Optional<String> phone,
                            @RequestParam("name") Optional<String> name,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        return service.findAll();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "")
    public Hazmat update(@PathVariable String id,
                          @RequestBody Hazmat hazmat,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.update(id, hazmat);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "")
    public Hazmat delete(@PathVariable String id,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.delete(id);
    }
}
