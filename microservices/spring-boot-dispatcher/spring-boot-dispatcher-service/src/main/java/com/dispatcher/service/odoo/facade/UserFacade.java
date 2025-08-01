package com.dispatcher.service.odoo.facade;

import com.dispatcher.service.model.Currency;
import com.dispatcher.service.odoo.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UserFacade {

    private static final Logger logger = LoggerFactory.getLogger(UserFacade.class);

    private final String _MODEL = "res.users";
    private final Session session;

    public UserFacade(Session session) {
        this.session = session;
    }

    public List<Currency> find() {
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
}
