package com.dispatcher.common.service.impl;

import com.dispatcher.common.service.CountryStateService;
import com.dispatcher.service.entity.State;
import com.dispatcher.service.odoo.api.*;
import com.dispatcher.service.odoo.facade.OdooCountryStateFacade;
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
public class CountryStateServiceImpl implements CountryStateService<State> {

    private static final Logger logger = LoggerFactory.getLogger(CountryStateServiceImpl.class);

    private final Translator translator;
    private final Environment environment;
    private final Session session;
    private final OdooCountryStateFacade facade;

    CountryStateServiceImpl(Environment environment, Translator translator, Session session) {
        this.environment = environment;
        this.translator = translator;
        this.session = session;
        this.facade = new OdooCountryStateFacade(session);
    }

    @Override
    public State findByPKey(String id) {
        return null;
    }

    @Override
    public List<State> findAll() {
        List<State> result = null;
        try {
            result = facade.find();
        } catch (Exception e) {
            logger.error("error: ", e.getMessage());
        }
        return result;
    }
}
