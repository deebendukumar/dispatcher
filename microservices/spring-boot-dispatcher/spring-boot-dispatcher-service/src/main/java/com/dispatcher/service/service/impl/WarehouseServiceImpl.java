package com.dispatcher.service.service.impl;

import com.dispatcher.service.service.WarehouseService;
import com.dispatcher.service.model.Warehouse;
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

    WarehouseServiceImpl(Environment environment, Translator translator) {
        this.environment = environment;
        this.translator = translator;
    }

    @Override
    public Warehouse findByPKey(Integer id) {
        return null;
    }

    @Override
    public List<Warehouse> find(Optional<String> code) {
        return null;
    }

    @Override
    public void create(Warehouse warehouse) {
    }
}
