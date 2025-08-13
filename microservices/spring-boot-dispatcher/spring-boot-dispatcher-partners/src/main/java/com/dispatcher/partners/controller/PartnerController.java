package com.dispatcher.partners.controller;

import com.dispatcher.service.model.Partner;
import com.dispatcher.partners.service.PartnerService;
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
@RequestMapping("/partners")
@Tag(name = "Partners", description = "API for managing business partners")
public class PartnerController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(PartnerController.class);

    private final PartnerService<Partner> service;

    PartnerController(PartnerService<Partner> service) {
        this.service = service;
    }

    @PostMapping(path = "")
    @Operation(summary = "Create a new partner")
    public Partner create(@RequestBody Partner partner,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.create(partner);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get partner by ID")
    public Partner find(@PathVariable String id,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        return service.findByPKey(id);
    }

    @GetMapping(path = "")
    @Operation(summary = "Get all partners or filter them by phone number or name")
    public List<Partner> findBy(@RequestParam("phone") Optional<String> phone,
                                @RequestParam("name") Optional<String> name,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        if (phone.isPresent())
            return service.findByPhone(phone.get());
        else if (name.isPresent())
            return service.findByName(name.get());
        else
            return service.findAll();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "Update a partner")
    public Partner update(@PathVariable String id,
                          @RequestBody Partner partner,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.update(id, partner);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Deactivate a partner")
    public Partner delete(@PathVariable String id,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.delete(id);
    }
}
