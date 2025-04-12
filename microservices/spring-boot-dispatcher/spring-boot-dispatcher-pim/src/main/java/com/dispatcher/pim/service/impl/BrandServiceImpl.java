package com.dispatcher.pim.service.impl;

import com.dispatcher.pim.entity.Brand;
import com.dispatcher.pim.entity.Variant;
import com.dispatcher.pim.repository.BrandRepository;
import com.dispatcher.pim.repository.VariantRepository;
import com.dispatcher.pim.service.BrandService;
import com.dispatcher.pim.service.VariantService;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;

import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class BrandServiceImpl implements BrandService<Brand> {

    private final BrandRepository repository;
    private final Translator translator;

    BrandServiceImpl(BrandRepository repository, Translator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    @Override
    public Brand findByPKey(String id) {
        return null;
    }

    @Override
    public List<Brand> findAll() {
        return null;
    }

    @Override
    public Brand create(Brand brand) {
        return null;
    }

    @Override
    public Brand update(String id, Brand brand) {
        return null;
    }

    @Override
    public Brand delete(String id) {
        return null;
    }
}
