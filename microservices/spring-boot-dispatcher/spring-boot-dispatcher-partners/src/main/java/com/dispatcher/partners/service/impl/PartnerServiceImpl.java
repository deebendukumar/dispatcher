package com.dispatcher.partners.service.impl;

import com.dispatcher.partners.entity.Partner;
import com.dispatcher.partners.repository.PartnerRepository;
import com.dispatcher.partners.service.PartnerService;
import com.dispatcher.service.config.MessageCodes;
import com.dispatcher.service.exception.DataNotFoundException;
import org.ameba.annotation.Measured;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;

import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class PartnerServiceImpl implements PartnerService<Partner> {

    private final PartnerRepository repository;
    private final Translator translator;

    PartnerServiceImpl(PartnerRepository repository, Translator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    @Override
    @Measured
    public Partner findByPKey(String id) {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException(translator,
                MessageCodes.TO_WITH_PK_NOT_FOUND,
                new String[]{id}, id));
    }

    @Override
    @Measured
    public List<Partner> findByPhone(String phone) {
        return null;
    }

    @Override
    @Measured
    public List<Partner> findByName(String name) {
        return null;
    }

    @Override
    @Measured
    public List<Partner> findAll() {
        return null;
    }

    @Override
    @Measured
    public Partner create(Partner partner) {
        return repository.save(partner);
    }

    @Override
    @Measured
    public Partner update(String id, Partner partner) {
        return null;
    }

    @Override
    @Measured
    public Partner delete(String id) {
        return null;
    }
}
