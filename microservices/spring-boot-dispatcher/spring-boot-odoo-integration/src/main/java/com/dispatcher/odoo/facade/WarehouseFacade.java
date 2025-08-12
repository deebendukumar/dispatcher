package com.dispatcher.odoo.facade;

import com.dispatcher.odoo.FilterCollection;
import com.dispatcher.odoo.Row;
import com.dispatcher.odoo.Session;
import com.dispatcher.odoo.exception.OdooApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WarehouseFacade extends OdooApiClient {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseFacade.class);

    private static final String _MODEL = "stock.warehouse";

    public WarehouseFacade(Session session) throws XmlRpcException, OdooApiException {
        super(session, _MODEL);
    }

    public List<Row> findByCode(String code) throws OdooApiException, XmlRpcException {
        List<Row> result = new ArrayList<>();
        FilterCollection filters = new FilterCollection();
        filters.add("code", "=", code);
        result = find(filters);
        return result;
    }

//    private Warehouse parse(Row row) {
//        String json = row.toJson();
//        logger.info(json);
//        OdooWarehouseObject odooWarehouseObject = toOdooWarehouseObject(json);
//        Warehouse warehouse = convert(odooWarehouseObject);
//        return warehouse;
//    }

//    private Warehouse convert(OdooWarehouseObject source) {
//        return WarehouseJsonMapper.INSTANCE.toWarehouse(source.getFieldsOdoo());
//    }
//
//    private OdooWarehouseObject toOdooWarehouseObject(String json) {
//        OdooWarehouseObject result = null;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            result = mapper.readValue(json, OdooWarehouseObject.class);
//        } catch (JsonProcessingException ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
}
