package com.dispatcher.service.odoo.facade;

import com.dispatcher.service.entity.Currency;
import com.dispatcher.service.odoo.api.*;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CurrencyFacade implements OdooCommonInterface<Currency> {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyFacade.class);

    private final String _MODEL = "res.currency";
    private final Session session;

    public CurrencyFacade(Session session) {
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
            if (list != null && !list.isEmpty()) {
                result = parse(list.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Currency> find() {
        List<Currency> result = new ArrayList<>();
        try {
            ObjectAdapter adapter = session.getObjectAdapter(_MODEL);
            FilterCollection filters = new FilterCollection();
            RowCollection list = adapter.searchAndReadObject(filters, new String[]{});
            for (Row row : list) {
                result.add(parse(row));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private Currency parse(Row row) {
        logger.info(row.toJson());
        Currency currency = Currency.valueOf(row);
        return currency;
    }
}
