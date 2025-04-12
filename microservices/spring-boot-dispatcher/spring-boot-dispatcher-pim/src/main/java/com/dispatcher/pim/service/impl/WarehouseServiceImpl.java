package com.dispatcher.pim.service.impl;

import com.dispatcher.pim.entity.Warehouse;
import com.dispatcher.pim.repository.WarehouseRepository;
import com.dispatcher.pim.service.WarehouseService;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;

import java.util.List;
import java.util.NoSuchElementException;

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
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(translator.translate("warehouse.not.found", id)));
    }

    @Override
    public List<Warehouse> findAll() {
        return repository.findAll();
    }

    @Override
    public Warehouse create(Warehouse warehouse) {
        return repository.save(warehouse);
    }

    @Override
    public Warehouse update(String id, Warehouse warehouse) {
        return repository.findById(id)
                .map(existingWarehouse -> {
                    warehouse.setId(id);
                    return repository.save(warehouse);
                })
                .orElseThrow(() -> new NoSuchElementException("Warehouse with id " + id + " not found"));
    }

    @Override
    public Warehouse delete(String id) {
        return repository.findById(id)
                .map(warehouse -> {
                    repository.delete(warehouse);
                    return warehouse;
                })
                .orElseThrow(() -> new NoSuchElementException("Warehouse with id " + id + " not found"));
    }

}
