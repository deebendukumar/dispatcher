package com.dispatcher.service.odoo.facade;

import com.dispatcher.service.entity.Partner;
import com.dispatcher.service.odoo.api.*;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class OdooPartnerFacade implements OdooInterface<Partner> {

    private static final Logger logger = LoggerFactory.getLogger(OdooPartnerFacade.class);

    private final String _MODEL = "res.partner";
    private final Session session;

    public OdooPartnerFacade(Session session) {
        this.session = session;
    }

    @Override
    public Partner findByPKey(Integer id) {
        Partner result = null;
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
    public List<Partner> find() {
        List<Partner> result = new ArrayList<>();
        try {
            ObjectAdapter adapter = session.getObjectAdapter(_MODEL);
            FilterCollection filters = new FilterCollection();
            filters.add("name","=","SO001");
//            RowCollection list = partners.searchAndReadObject(filters, new String[]{"l10n_in_pan","type","activity_state", "vat", "is_blacklisted", "active"});
            RowCollection list = adapter.searchAndReadObject(filters, new String[]{});
            for (Row row : list) {
                result.add(parse(row));
            }
        } catch (Exception e) {
            logger.error("error: ", e.getMessage());
        }
        return result;
    }

    @Override
    public Partner create(Partner param) {
        Partner result = null;
        try {
            ObjectAdapter adapter = session.getObjectAdapter(_MODEL);
            Row newPartner = adapter.getNewRow(new String[]{"name", "ref", "email", "field1", "field2"});
            newPartner.put("name", "Jhon Doe");
            newPartner.put("ref", "Reference value");
            newPartner.put("email", "personalemail@mail.com");
            newPartner.put("field1", "1");
            newPartner.put("field2", "2");
            adapter.createObject(newPartner);
        } catch (Exception e) {
            logger.error("error: ", e.getMessage());
        }
        return result;
    }

    @Override
    public Partner update(Integer id, Partner param) {
        Partner result = null;
        try {
            ObjectAdapter adapter = session.getObjectAdapter(_MODEL);
            Row newPartner = adapter.getNewRow(new String[]{"name", "ref", "email", "field1", "field2"});
            newPartner.put("name", "Jhon Doe");
            newPartner.put("ref", "Reference value");
            newPartner.put("email", "personalemail@mail.com");
            newPartner.put("field1", "1");
            newPartner.put("field2", "2");
            adapter.writeObject(newPartner, true);
        } catch (Exception e) {
            logger.error("error: ", e.getMessage());
        }
        return result;
    }

    @Override
    public void delete(Integer id) {
        try {
            ObjectAdapter adapter = session.getObjectAdapter(_MODEL);
            FilterCollection filters = new FilterCollection();
            filters.add("id", "=", id);
            RowCollection list = adapter.searchAndReadObject(filters, new String[]{});
            adapter.unlinkObject(list);
        } catch (Exception e) {
            logger.error("error: ", e.getMessage());
        }
    }

    private Partner parse(Row row) {
        logger.info(row.toJson());
        Partner currency = Partner.valueOf(row);
        return currency;
    }
}
