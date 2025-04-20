package com.dispatcher.service.odoo.facade;

import com.dispatcher.service.entity.Country;
import com.dispatcher.service.entity.Currency;
import com.dispatcher.service.entity.State;
import com.dispatcher.service.odoo.api.*;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class OdooCountryStateFacade implements OdooInterface<State> {

    private static final Logger logger = LoggerFactory.getLogger(OdooCountryStateFacade.class);

    private final String _MODEL = "res.country.state";
    private final Session session;

    public OdooCountryStateFacade(Session session) {
        this.session = session;
    }

    @Override
    public State findByPKey(Integer id) {
        State result = null;
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
    public List<State> find() {
        List<State> result = new ArrayList<>();
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

    @Override
    public State create(State param) {
        throw new NotImplementedException("Method not implemented");
    }

    @Override
    public State update(Integer id, State param) {
        throw new NotImplementedException("Method not implemented");
    }

    @Override
    public void delete(Integer id) {
        throw new NotImplementedException("Method not implemented");
    }

    private State parse(Row row) {
        logger.info(row.toJson());
        State state = State.valueOf(row);
        return state;
    }
}
