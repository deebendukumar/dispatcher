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
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category create(Category category) {
        return null;
    }

    @Override
    public Category update(String id, Category category) {
        return null;
    }

    @Override
    public Category delete(String id) {
        return null;
    }
}
