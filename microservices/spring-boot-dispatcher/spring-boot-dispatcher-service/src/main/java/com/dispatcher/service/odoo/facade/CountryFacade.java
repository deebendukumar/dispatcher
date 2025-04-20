package com.dispatcher.service.odoo.facade;

import com.dispatcher.service.entity.Country;
import com.dispatcher.service.odoo.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CountryFacade implements OdooCommonInterface<Country> {

    private static final Logger logger = LoggerFactory.getLogger(CountryFacade.class);

    private final String _MODEL = "res.country";
    private final Session session;
    private final CurrencyFacade currencyFacade;
    private final CountryStateFacade odooCountryStateFacade;

    public CountryFacade(Session session) {
        this.session = session;
        this.currencyFacade = new CurrencyFacade(session);
        this.odooCountryStateFacade = new CountryStateFacade(session);
    }

    @Override
    public Country findByPKey(Integer id) {
        Country result = null;
        try {
            ObjectAdapter adapter = session.getObjectAdapter(_MODEL);
            FilterCollection filters = new FilterCollection();
            filters.add("id", "=", id);
            RowCollection list = adapter.searchAndReadObject(filters, new String[]{});
            if (list != null && !list.isEmpty()) {
                result = parse(list.get(0));
            }
        } catch (Exception e) {
            logger.error("error: ", e.getMessage());
        }
        return result;
    }

    @Override
    public List<Country> find() {
        List<Country> result = new ArrayList<>();
        try {
            ObjectAdapter adapter = session.getObjectAdapter(_MODEL);
            FilterCollection filters = new FilterCollection();
            RowCollection list = adapter.searchAndReadObject(filters, new String[]{});
            for (Row row : list) {
                result.add(parse(row));
            }
        } catch (Exception e) {
            logger.error("error: ", e.getMessage());
        }
        return result;
    }

    private Country parse(Row row) {
        logger.info(row.toJson());
        Country country = Country.valueOf(row);
        return country;
    }
}
