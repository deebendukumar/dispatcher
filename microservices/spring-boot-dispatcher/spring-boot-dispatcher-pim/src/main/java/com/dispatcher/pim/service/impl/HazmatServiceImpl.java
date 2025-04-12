package com.dispatcher.pim.service.impl;

import com.dispatcher.pim.entity.Hazmat;
import com.dispatcher.pim.entity.Variant;
import com.dispatcher.pim.repository.HazmatRepository;
import com.dispatcher.pim.repository.VariantRepository;
import com.dispatcher.pim.service.HazmatService;
import com.dispatcher.pim.service.VariantService;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;

import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class HazmatServiceImpl implements HazmatService<Hazmat> {

    private final HazmatRepository repository;
    private final Translator translator;

    HazmatServiceImpl(HazmatRepository repository, Translator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    @Override
    public Hazmat findByPKey(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(translator.translate("hazmat.not.found", id)));
    }

    @Override
    public List<Hazmat> findAll() {
        return repository.findAll();
    }

    @Override
    public Hazmat create(Hazmat hazmat) {
        return repository.save(hazmat);
    }

    @Override
    public Hazmat update(String id, Hazmat hazmat) {
        return repository.findById(id)
                .map(existingHazmat -> {
                    hazmat.setId(id);
                    return repository.save(hazmat);
                })
                .orElseThrow(() -> new IllegalArgumentException(translator.translate("hazmat.not.found", id)));
    }

    @Override
    public Hazmat delete(String id) {
            return repository.findById(id)
                    .map(existingHazmat -> {
                        repository.delete(existingHazmat);
                        return existingHazmat;
                    })
                    .orElseThrow(() -> new IllegalArgumentException(translator.translate("hazmat.not.found", id)));
    }
}
