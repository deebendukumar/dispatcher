package com.dispatcher.odoo.facade;

import com.dispatcher.odoo.*;
import com.dispatcher.odoo.exception.OdooApiException;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CurrencyFacade extends OdooApiClient {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyFacade.class);

    private static final String _MODEL = "res.currency";

    public CurrencyFacade(Session session) throws XmlRpcException, OdooApiException {
        super(session, _MODEL);
    }
}
