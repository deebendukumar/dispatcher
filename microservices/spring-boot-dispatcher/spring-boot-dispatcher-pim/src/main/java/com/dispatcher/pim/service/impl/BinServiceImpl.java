package com.dispatcher.pim.service.impl;

import com.dispatcher.pim.entity.Bin;
import com.dispatcher.pim.entity.Variant;
import com.dispatcher.pim.repository.BinRepository;
import com.dispatcher.pim.repository.VariantRepository;
import com.dispatcher.pim.service.BinService;
import com.dispatcher.pim.service.VariantService;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;

import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class BinServiceImpl implements BinService<Bin> {

    private final BinRepository repository;
    private final Translator translator;

    BinServiceImpl(BinRepository repository, Translator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    @Override
    public Bin findByPKey(String id) {
        return null;
    }

    @Override
    public List<Bin> findAll() {
        return null;
    }

    @Override
    public Bin create(Bin bin) {
        return null;
    }

    @Override
    public Bin update(String id, Bin bin) {
        return null;
    }

    @Override
    public Bin delete(String id) {
        return null;
    }
}
