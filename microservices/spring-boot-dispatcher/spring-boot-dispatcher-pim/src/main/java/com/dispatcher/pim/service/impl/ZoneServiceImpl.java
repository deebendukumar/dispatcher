package com.dispatcher.pim.service.impl;

import com.dispatcher.pim.entity.Warehouse;
import com.dispatcher.pim.entity.Zone;
import com.dispatcher.pim.repository.WarehouseRepository;
import com.dispatcher.pim.repository.ZoneRepository;
import com.dispatcher.pim.service.WarehouseService;
import com.dispatcher.pim.service.ZoneService;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;

import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class ZoneServiceImpl implements ZoneService<Zone> {

    private final ZoneRepository repository;
    private final Translator translator;

    ZoneServiceImpl(ZoneRepository repository, Translator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    @Override
    public Zone findByPKey(String id) {
        return null;
    }

    @Override
    public List<Zone> findAll() {
        return null;
    }

    @Override
    public Zone create(Zone zone) {
        return null;
    }

    @Override
    public Zone update(String id, Zone zone) {
        return null;
    }

    @Override
    public Zone delete(String id) {
        return null;
    }
}
