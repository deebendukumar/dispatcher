package com.dispatcher.partners.service.impl;

import com.dispatcher.service.entity.Partner;
import com.dispatcher.partners.repository.PartnerRepository;
import com.dispatcher.partners.service.PartnerService;
import com.dispatcher.service.config.MessageCodes;
import com.dispatcher.service.exception.DataNotFoundException;
import com.dispatcher.service.odoo.api.*;
import com.dispatcher.service.odoo.facade.PartnerFacade;
import org.ameba.annotation.Measured;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import java.util.*;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class PartnerServiceImpl implements PartnerService<Partner> {

    private static final Logger logger = LoggerFactory.getLogger(PartnerServiceImpl.class);

    private final PartnerRepository repository;
    private final Translator translator;
    private final Environment environment;
    private final Session session;
    private final PartnerFacade facade;

    PartnerServiceImpl(Environment environment, PartnerRepository repository, Translator translator, Session session) {
        this.environment = environment;
        this.repository = repository;
        this.translator = translator;
        this.session = session;
        this.facade = new PartnerFacade(session);
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
        List<Partner> result = this.facade.find(Optional.empty(), Optional.of(phone), Optional.empty());
        return result;
    }

    @Override
    @Measured
    public List<Partner> findByName(String name) {
        List<Partner> result = this.facade.find(Optional.of(name), Optional.empty(), Optional.empty());
        return result;
    }

    @Override
    @Measured
    public List<Partner> findAll() {
        List<Partner> result = this.facade.find(Optional.empty(), Optional.empty(), Optional.empty());
        return result;
    }

    @Override
    @Measured
    public Partner create(Partner partner) {
        Partner result = null;
        try {
            ObjectAdapter partners = session.getObjectAdapter("res.partner");
            Row newPartner = partners.getNewRow(new String[]{"name", "ref", "email", "field1", "field2"});
            newPartner.put("name", "Jhon Doe");
            newPartner.put("ref", "Reference value");
            newPartner.put("email", "personalemail@mail.com");
            newPartner.put("field1", "1");
            newPartner.put("field2", "2");
            partners.createObject(newPartner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Measured
    public Partner update(String id, Partner partner) {
//        return repository.findById(id)
//                .map(existingPartner -> {
//                    partner.setId(id);
//                    return repository.save(partner);
//                })
//                .orElseThrow(() -> new DataNotFoundException(translator,
//                        MessageCodes.TO_WITH_PK_NOT_FOUND,
//                        new String[]{id}, id));
        return null;
    }

    @Override
    @Measured
    public Partner delete(String id) {
        return repository.findById(id)
                .map(partner -> {
                    repository.delete(partner);
                    return partner;
                })
                .orElseThrow(() -> new NoSuchElementException("Partner with id " + id + " not found"));
    }
}
