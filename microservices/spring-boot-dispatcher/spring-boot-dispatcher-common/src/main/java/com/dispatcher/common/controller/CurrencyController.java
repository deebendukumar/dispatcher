package com.dispatcher.common.controller;

import com.dispatcher.service.model.Currency;
import com.dispatcher.common.service.CurrencyService;
import com.dispatcher.service.base.http.AbstractWebController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@Tag(name = "Currencies", description = "API for managing currencies")
public class CurrencyController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);

    private final CurrencyService<Currency> service;

    CurrencyController(CurrencyService<Currency> service) {
        this.service = service;
    }

    @GetMapping(path = "")
    @Operation(summary = "Get all currencies")
    public List<Currency> find(HttpServletRequest request,
                               HttpServletResponse response) {
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get partner by ID")
    public Currency findById(@PathVariable Integer id,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        return service.findByPKey(id);
    }
}
