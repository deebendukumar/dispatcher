package com.dispatcher.common.service.impl;

import com.dispatcher.service.entity.Currency;
import com.dispatcher.common.service.CurrencyService;
import com.dispatcher.service.odoo.api.*;
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
    private final Session session;

    CurrencyServiceImpl(Environment environment, Translator translator, Session session) {
        this.environment = environment;
        this.translator = translator;
        this.session = session;
    }

    @Override
    public Currency findByPKey(Integer id) {
        Currency result = null;
        try {
            ObjectAdapter adapter = session.getObjectAdapter(_MODEL);
            FilterCollection filters = new FilterCollection();
            filters.add("id", "=", id);
            RowCollection list = adapter.searchAndReadObject(filters, new String[]{});
            for (Row row : list) {
                result = Currency.valueOf(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Currency> findAll() {
        List<Currency> result = new ArrayList<>();
        try {
            ObjectAdapter adapter = session.getObjectAdapter(_MODEL);
            FilterCollection filters = new FilterCollection();
            RowCollection list = adapter.searchAndReadObject(filters, new String[]{});
            for (Row row : list) {
                Currency currency = Currency.valueOf(row);
                result.add(currency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
