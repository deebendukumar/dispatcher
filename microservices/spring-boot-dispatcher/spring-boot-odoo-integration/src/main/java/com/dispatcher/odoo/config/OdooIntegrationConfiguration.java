package com.dispatcher.odoo.config;

import com.dispatcher.odoo.OdooXmlRpcProxy;
import com.dispatcher.odoo.RPCProtocol;
import com.dispatcher.odoo.Session;
import org.ameba.i18n.AbstractSpringTranslator;
import org.ameba.i18n.Translator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("com.dispatcher.odoo")
public class OdooIntegrationConfiguration {

    private final Environment environment;

    OdooIntegrationConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public Session session() throws Exception {
        Session session = new Session(RPCProtocol.RPC_HTTP,
                environment.getProperty("odoo.host"),
                Integer.parseInt(environment.getProperty("odoo.port")),
                environment.getProperty("odoo.db"),
                environment.getProperty("odoo.username"),
                environment.getProperty("odoo.password"));
        return session;
    }
}

