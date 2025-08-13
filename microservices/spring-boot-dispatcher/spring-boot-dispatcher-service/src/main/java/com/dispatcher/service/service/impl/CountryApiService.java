package com.dispatcher.service.service.impl;

import com.dispatcher.odoo.Session;
import com.dispatcher.odoo.exception.OdooApiException;
import com.dispatcher.odoo.facade.CountryApiClient;
import org.ameba.annotation.TxService;
import org.ameba.i18n.Translator;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

/**
 * A TxService is a stereotype annotation to define a transactional Spring managed service.
 * A Measured is a marker annotation on classes or public methods to indicate that the annotated class or method are being tracked in terms
 */
@TxService
public class CountryApiService extends OdooApiService {

    private static final Logger logger = LoggerFactory.getLogger(CountryApiService.class);

    private final Translator translator;
    private final Environment environment;

    CountryApiService(Environment environment, Translator translator, Session session) {
        this.environment = environment;
        this.translator = translator;
        facade = createCountryFacade(session);
    }

    public static CountryApiClient createCountryFacade(Session session) {
        CountryApiClient facade = null;
        try {
            facade = new CountryApiClient(session);
        } catch (XmlRpcException e) {
            logger.error("error creating country facade {}", e.getMessage());
        } catch (OdooApiException e) {
            logger.error("error creating country facade {}", e.getMessage());
        }
        return facade;
    }
}
