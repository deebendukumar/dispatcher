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
import java.util.NoSuchElementException;

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
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(translator.translate("zone.not.found", id)));
    }

    @Override
    public List<Zone> findAll() {
        return repository.findAll();
    }

    @Override
    public Zone create(Zone zone) {
        return repository.save(zone);
    }

    @Override
    public Zone update(String id, Zone zone) {
        return repository.findById(id)
                .map(existingZone -> {
                    zone.setId(id);
                    return repository.save(zone);
                })
                .orElseThrow(() -> new IllegalArgumentException(translator.translate("zone.not.found", id)));
    }

    @Override
    public Zone delete(String id) {
        return repository.findById(id)
                .map(zone -> {
                    repository.delete(zone);
                    return zone;
                })
                .orElseThrow(() -> new NoSuchElementException("Zone with id " + id + " not found"));
    }

}
