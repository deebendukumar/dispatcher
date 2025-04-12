package com.dispatcher.pim.service.impl;

import com.dispatcher.pim.entity.Rack;
import com.dispatcher.pim.entity.Variant;
import com.dispatcher.pim.repository.RackRepository;
import com.dispatcher.pim.repository.VariantRepository;
import com.dispatcher.pim.service.RackService;
import com.dispatcher.pim.service.VariantService;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;

import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class RackServiceImpl implements RackService<Rack> {

    private final RackRepository repository;
    private final Translator translator;

    RackServiceImpl(RackRepository repository, Translator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    @Override
    public Rack findByPKey(String id) {
        return null;
    }

    @Override
    public List<Rack> findAll() {
        return null;
    }

    @Override
    public Rack create(Rack rack) {
        return null;
    }

    @Override
    public Rack update(String id, Rack rack) {
        return null;
    }

    @Override
    public Rack delete(String id) {
        return null;
    }
}
