package com.dispatcher.service.odoo.facade;

import com.dispatcher.service.model.Warehouse;
import com.dispatcher.service.odoo.api.*;
import com.dispatcher.service.odoo.mapper.WarehouseJsonMapper;
import com.dispatcher.service.odoo.model.OdooWarehouseObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class WarehouseFacade {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseFacade.class);

    private final String _MODEL = "stock.warehouse";
    private final Session session;

    public WarehouseFacade(Session session) {
        this.session = session;
    }

    public Warehouse findByPKey(Integer id) {
        Warehouse result = null;
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

    public List<Warehouse> find() {
        return find(Optional.empty());
    }

    public List<Warehouse> find(Optional<String> code) {
        List<Warehouse> result = new ArrayList<>();
        try {
            ObjectAdapter adapter = session.getObjectAdapter(_MODEL);
            FilterCollection filters = new FilterCollection();
            if (code.isPresent()) {
                filters.add("code", "=", code.get());
            }
            RowCollection list = adapter.searchAndReadObject(filters, new String[]{});
            for (Row row : list) {
                result.add(parse(row));
            }
        } catch (Exception e) {
            logger.error("error: ", e.getMessage());
        }
        return result;
    }

    private Warehouse parse(Row row) {
        String json = row.toJson();
        logger.info(json);
        OdooWarehouseObject odooWarehouseObject = toOdooWarehouseObject(json);
        Warehouse warehouse = convert(odooWarehouseObject);
        return warehouse;
    }

    private Warehouse convert(OdooWarehouseObject source) {
        return WarehouseJsonMapper.INSTANCE.toWarehouse(source.getFieldsOdoo());
    }

    private OdooWarehouseObject toOdooWarehouseObject(String json) {
        OdooWarehouseObject result = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(json, OdooWarehouseObject.class);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
