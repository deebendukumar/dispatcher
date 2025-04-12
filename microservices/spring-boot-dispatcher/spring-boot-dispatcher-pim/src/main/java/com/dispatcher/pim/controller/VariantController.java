package com.dispatcher.pim.controller;

import com.dispatcher.pim.entity.Bin;
import com.dispatcher.pim.entity.Variant;
import com.dispatcher.pim.service.BinService;
import com.dispatcher.pim.service.VariantService;
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
@RequestMapping("/variants")
@Tag(name = "Variants", description = "")
public class VariantController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(VariantController.class);

    private final VariantService<Variant> service;

    VariantController(VariantService<Variant> service) {
        this.service = service;
    }

    @PostMapping(path = "")
    @Operation(summary = "")
    public Variant create(@RequestBody Variant variant,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        return service.create(variant);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "")
    public Variant find(@PathVariable String id,
                    HttpServletRequest request,
                    HttpServletResponse response) {
        return service.findByPKey(id);
    }

    @GetMapping(path = "")
    @Operation(summary = "")
    public List<Variant> findBy(@RequestParam("phone") Optional<String> phone,
                            @RequestParam("name") Optional<String> name,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        return service.findAll();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "")
    public Variant update(@PathVariable String id,
                          @RequestBody Variant variant,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.update(id, variant);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "")
    public Variant delete(@PathVariable String id,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.delete(id);
    }
}
