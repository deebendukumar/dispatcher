package com.dispatcher.service.service.impl;

import com.dispatcher.odoo.FilterCollection;
import com.dispatcher.odoo.Row;
import com.dispatcher.odoo.Session;
import com.dispatcher.odoo.exception.OdooApiException;
import com.dispatcher.odoo.facade.OdooApiClient;
import com.dispatcher.odoo.facade.PartnerFacade;
import com.dispatcher.odoo.facade.WarehouseFacade;
import com.dispatcher.service.model.Partner;
import com.dispatcher.service.service.WarehouseService;
import com.dispatcher.service.model.Warehouse;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class WarehouseServiceImpl implements WarehouseService<HashMap<String, Object>> {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseServiceImpl.class);

    private final Translator translator;
    private final Environment environment;
    private final OdooApiClient facade;

    WarehouseServiceImpl(Environment environment, Translator translator, Session session) {
        this.environment = environment;
        this.translator = translator;
        facade = createWarehouseFacade(session);
    }

    public static WarehouseFacade createWarehouseFacade(Session session) {
        WarehouseFacade facade = null;
        try {
            facade = new WarehouseFacade(session);
        } catch (XmlRpcException e) {
            logger.error("error creating warehouse facade {}", e.getMessage());
        } catch (OdooApiException e) {
            logger.error("error creating warehouse facade {}", e.getMessage());
        }
        return facade;
    }

    @Override
    public HashMap<String, Object> findByPKey(Integer id) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> find(Optional<String> code) {
        List<HashMap<String, Object>> result = new ArrayList<>();
        try {
            List<Row> list = this.facade.find(new FilterCollection());
            for (Row row : list) {
                result.add(row.getFieldsOdoo());
                logger.info(row.toJson());
            }
        } catch (OdooApiException e) {
            e.printStackTrace();
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void create(Warehouse warehouse) {
    }

    private List fields() {
        return List.of("id", "write_date");
    }
}
