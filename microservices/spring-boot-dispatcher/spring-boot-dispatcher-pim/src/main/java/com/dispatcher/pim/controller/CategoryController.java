package com.dispatcher.pim.controller;

import com.dispatcher.pim.entity.Category;
import com.dispatcher.pim.service.CategoryService;
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
@RequestMapping("/categories")
@Tag(name = "Categories", description = "")
public class CategoryController extends AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryService<Category> service;

    CategoryController(CategoryService<Category> service) {
        this.service = service;
    }

    @PostMapping(path = "")
    @Operation(summary = "")
    public Category create(@RequestBody Category category,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        return service.create(category);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "")
    public Category find(@PathVariable String id,
                    HttpServletRequest request,
                    HttpServletResponse response) {
        return service.findByPKey(id);
    }

    @GetMapping(path = "")
    @Operation(summary = "")
    public List<Category> findBy(@RequestParam("phone") Optional<String> phone,
                            @RequestParam("name") Optional<String> name,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        return service.findAll();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "")
    public Category update(@PathVariable String id,
                          @RequestBody Category category,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.update(id, category);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "")
    public Category delete(@PathVariable String id,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        return service.delete(id);
    }
}
