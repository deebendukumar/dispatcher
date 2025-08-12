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

    public
    @Bean
    Session session() throws Exception {
        Session session = new Session(RPCProtocol.RPC_HTTP,
                this.environment.getProperty("odoo.host"),
                Integer.parseInt(this.environment.getProperty("odoo.port")),
                this.environment.getProperty("odoo.database"),
                this.environment.getProperty("odoo.username"),
                this.environment.getProperty("odoo.password"));
        session.startSession();
        return session;
    }
}

