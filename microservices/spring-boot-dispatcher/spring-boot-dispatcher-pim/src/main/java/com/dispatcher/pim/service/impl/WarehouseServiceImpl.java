package com.dispatcher.pim.service.impl;

import com.dispatcher.pim.entity.Warehouse;
import com.dispatcher.pim.repository.WarehouseRepository;
import com.dispatcher.pim.service.WarehouseService;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;

import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class WarehouseServiceImpl implements WarehouseService<Warehouse> {

    private final WarehouseRepository repository;
    private final Translator translator;

    WarehouseServiceImpl(WarehouseRepository repository, Translator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    @Override
    public Warehouse findByPKey(String id) {
        return null;
    }

    @Override
    public List<Warehouse> findAll() {
        return null;
    }

    @Override
    public Warehouse create(Warehouse warehouse) {
        return null;
    }

    @Override
    public Warehouse update(String id, Warehouse warehouse) {
        return null;
    }

    @Override
    public Warehouse delete(String id) {
        return null;
    }
}
