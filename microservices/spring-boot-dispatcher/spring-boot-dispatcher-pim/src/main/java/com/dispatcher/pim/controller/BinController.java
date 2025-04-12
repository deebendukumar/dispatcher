package com.dispatcher.pim.controller;

import com.dispatcher.pim.entity.Bin;
import com.dispatcher.pim.service.BinService;
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
@RequestMapping("/bins")
@Tag(name = "Bins", description = "")
public class BinController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(BinController.class);

    private final BinService<Bin> service;

    BinController(BinService<Bin> service) {
        this.service = service;
    }

    @PostMapping(path = "")
    @Operation(summary = "")
    public Bin create(@RequestBody Bin bin,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        return service.create(bin);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "")
    public Bin find(@PathVariable String id,
                    HttpServletRequest request,
                    HttpServletResponse response) {
        return service.findByPKey(id);
    }

    @GetMapping(path = "")
    @Operation(summary = "")
    public List<Bin> findBy(@RequestParam("phone") Optional<String> phone,
                            @RequestParam("name") Optional<String> name,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        return service.findAll();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "")
    public Bin update(@PathVariable String id,
                          @RequestBody Bin bin,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.update(id, bin);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "")
    public Bin delete(@PathVariable String id,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.delete(id);
    }
}
