package com.dispatcher.service.service.impl;

import com.dispatcher.odoo.Session;
import com.dispatcher.odoo.exception.OdooApiException;
import com.dispatcher.odoo.facade.WarehouseApiClient;
import com.dispatcher.service.model.Warehouse;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class WarehouseApiService extends OdooApiService {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseApiService.class);

    private final Translator translator;
    private final Environment environment;

    WarehouseApiService(Environment environment, Translator translator, Session session) {
        this.environment = environment;
        this.translator = translator;
        facade = createWarehouseFacade(session);
    }

    public static WarehouseApiClient createWarehouseFacade(Session session) {
        WarehouseApiClient facade = null;
        try {
            facade = new WarehouseApiClient(session);
        } catch (XmlRpcException e) {
            logger.error("error creating warehouse facade {}", e.getMessage());
        } catch (OdooApiException e) {
            logger.error("error creating warehouse facade {}", e.getMessage());
        }
        return facade;
    }

    public void create(Warehouse warehouse) {
    }

    private List fields() {
        return List.of("id", "write_date");
    }
}
