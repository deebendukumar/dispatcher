package com.dispatcher.common.service.impl;

import com.dispatcher.common.service.WarehouseService;
import com.dispatcher.service.model.Warehouse;
import com.dispatcher.service.odoo.api.Session;
import com.dispatcher.service.odoo.facade.WarehouseFacade;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Optional;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class WarehouseServiceImpl implements WarehouseService<Warehouse> {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseServiceImpl.class);

    private final Translator translator;
    private final Environment environment;
    private final Session session;
    private final WarehouseFacade facade;

    WarehouseServiceImpl(Environment environment, Translator translator, Session session, WarehouseFacade facade) {
        this.environment = environment;
        this.translator = translator;
        this.session = session;
        this.facade = facade;
    }

    @Override
    public Warehouse findByPKey(Integer id) {
        return facade.findByPKey(id);
    }

    @Override
    public List<Warehouse> find(Optional<String> code) {
        List<Warehouse> result = null;
        try {
            if (code.isPresent()) {
                result = facade.find(code);
            } else {
                result = facade.find();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
