package com.dispatcher.service.service.impl;

import com.dispatcher.service.model.Currency;
import com.dispatcher.service.model.State;
import com.dispatcher.service.service.CurrencyService;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class CurrencyServiceImpl implements CurrencyService<Currency> {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);

    private final String _MODEL = "res.currency";

    private final Translator translator;
    private final Environment environment;

    CurrencyServiceImpl(Environment environment, Translator translator) {
        this.environment = environment;
        this.translator = translator;
    }

    @Override
    public Currency findByPKey(Integer id) {
        return null;
    }

    @Override
    public List<Currency> findAll() {
        return null;
    }

}
