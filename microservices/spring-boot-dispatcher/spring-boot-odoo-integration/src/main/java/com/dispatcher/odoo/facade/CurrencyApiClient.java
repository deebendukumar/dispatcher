package com.dispatcher.odoo.facade;

import com.dispatcher.odoo.*;
import com.dispatcher.odoo.exception.OdooApiException;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyApiClient extends OdooApiClient {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyApiClient.class);

    private static final String _MODEL = "res.currency";

    public CurrencyApiClient(Session session) throws XmlRpcException, OdooApiException {
        super(session, _MODEL);
    }
}
