package com.dispatcher.pim.service.impl;

import com.dispatcher.pim.entity.Category;
import com.dispatcher.pim.entity.Variant;
import com.dispatcher.pim.repository.CategoryRepository;
import com.dispatcher.pim.repository.VariantRepository;
import com.dispatcher.pim.service.CategoryService;
import com.dispatcher.pim.service.VariantService;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class CategoryServiceImpl implements CategoryService<Category> {

    private final CategoryRepository repository;
    private final Translator translator;

    CategoryServiceImpl(CategoryRepository repository, Translator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    @Override
    public Category findByPKey(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(translator.translate("category.not.found", id)));
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(String id, Category category) {

        return repository.findById(id)
                .map(existingCategory -> {
                    category.setId(id);
                    return repository.save(category);
                })
                .orElseThrow(() -> new NoSuchElementException("Category with id " + id + " not found"));
    }

    @Override
    public Category delete(String id) {
        return repository.findById(id)
                .map(category -> {
                    repository.delete(category);
                    return category;
                })
                .orElseThrow(() -> new NoSuchElementException("Category with id " + id + " not found"));
    }

}
