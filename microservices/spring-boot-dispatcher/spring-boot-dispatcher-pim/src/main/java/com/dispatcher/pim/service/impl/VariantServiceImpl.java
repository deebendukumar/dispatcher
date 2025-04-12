package com.dispatcher.pim.service.impl;

import com.dispatcher.pim.entity.Variant;
import com.dispatcher.pim.entity.Zone;
import com.dispatcher.pim.repository.VariantRepository;
import com.dispatcher.pim.repository.ZoneRepository;
import com.dispatcher.pim.service.VariantService;
import com.dispatcher.pim.service.ZoneService;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;

import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class VariantServiceImpl implements VariantService<Variant> {

    private final VariantRepository repository;
    private final Translator translator;

    VariantServiceImpl(VariantRepository repository, Translator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    @Override
    public Variant findByPKey(String id) {
        return null;
    }

    @Override
    public List<Variant> findAll() {
        return null;
    }

    @Override
    public Variant create(Variant variant) {
        return null;
    }

    @Override
    public Variant update(String id, Variant variant) {
        return null;
    }

    @Override
    public Variant delete(String id) {
        return null;
    }
}
