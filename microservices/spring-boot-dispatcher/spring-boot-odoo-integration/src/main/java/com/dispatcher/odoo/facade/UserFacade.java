package com.dispatcher.odoo.facade;

import com.dispatcher.odoo.Session;
import com.dispatcher.odoo.exception.OdooApiException;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserFacade extends OdooApiClient {

    private static final Logger logger = LoggerFactory.getLogger(UserFacade.class);

    private static final String _MODEL = "res.users";

    public UserFacade(Session session) throws XmlRpcException, OdooApiException {
        super(session, _MODEL);
    }
}
