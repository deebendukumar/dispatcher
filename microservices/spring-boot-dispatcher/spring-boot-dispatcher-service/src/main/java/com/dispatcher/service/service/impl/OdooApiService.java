package com.dispatcher.service.service.impl;

import com.dispatcher.odoo.FilterCollection;
import com.dispatcher.odoo.Row;
import com.dispatcher.odoo.exception.OdooApiException;
import com.dispatcher.odoo.facade.OdooApiClient;
import org.ameba.annotation.TxService;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class OdooApiService {

    private static final Logger logger = LoggerFactory.getLogger(OdooApiService.class);

    protected OdooApiClient facade;

    OdooApiService(){
        this(null);
    }

    OdooApiService(OdooApiClient facade) {
        this.facade = facade;
    }

    public HashMap<String, Object> findByPKey(Integer id) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            Row row = this.facade.findByPKey(id);
            result = row.getFieldsOdoo();
        } catch (OdooApiException e) {
            e.printStackTrace();
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<HashMap<String, Object>> findAll() {
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

}
