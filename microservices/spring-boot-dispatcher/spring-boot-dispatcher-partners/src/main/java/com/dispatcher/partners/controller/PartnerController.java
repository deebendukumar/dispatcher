package com.dispatcher.partners.controller;

import com.dispatcher.partners.data.Partner;
import com.dispatcher.partners.service.PartnerService;
import com.dispatcher.service.exception.BadRequestException;
import com.dispatcher.service.http.AbstractWebController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partners")
public class PartnerController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(PartnerController.class);

    private final PartnerService<Partner> service;

    PartnerController(PartnerService<Partner> service) {
        this.service = service;
    }

    @PostMapping(path = "")
    public Partner create(@RequestBody Partner partner,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.create(partner);
    }

    @GetMapping(path = "/{id}")
    public Partner find(@PathVariable String id,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        return service.findByPKey(id);
    }

    @GetMapping(path = "")
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
    public Partner update(@PathVariable String id,
                          @RequestBody Partner partner,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.update(id, partner);
    }

    @DeleteMapping(path = "/{id}")
    public Partner delete(@PathVariable String id,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.delete(id);
    }
}
