package com.dispatcher.common.service.impl;

import com.dispatcher.service.entity.Country;
import com.dispatcher.common.service.CountryService;
import com.dispatcher.service.odoo.api.*;
import com.dispatcher.service.odoo.facade.CountryFacade;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class CountryServiceImpl implements CountryService<Country> {

    private static final Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);

    private final Translator translator;
    private final Environment environment;
    private final Session session;
    private final CountryFacade facade;

    CountryServiceImpl(Environment environment, Translator translator, Session session) {
        this.environment = environment;
        this.translator = translator;
        this.session = session;
        this.facade = new CountryFacade(session);
    }

    @Override
    public Country findByPKey(Integer id) {
        return facade.findByPKey(id);
    }

    @Override
    public List<Country> findAll() {
        List<Country> result = null;
        try {
            result = facade.find();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
