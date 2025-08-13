package com.dispatcher.odoo.facade;

import com.dispatcher.odoo.FilterCollection;
import com.dispatcher.odoo.Row;
import com.dispatcher.odoo.Session;
import com.dispatcher.odoo.exception.OdooApiException;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class WarehouseLocationApiClient extends OdooApiClient {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseLocationApiClient.class);

    private static final String _MODEL = "stock.location";

    public WarehouseLocationApiClient(Session session) throws XmlRpcException, OdooApiException {
        super(session, _MODEL);
    }
}
