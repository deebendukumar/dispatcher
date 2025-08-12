package com.dispatcher.app.config;

import com.dispatcher.odoo.RPCProtocol;
import com.dispatcher.odoo.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DispatcherConfiguration {

    private final Environment environment;

    DispatcherConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public Session session() {
        Session session = new Session(RPCProtocol.RPC_HTTP,
                environment.getProperty("odoo.host"),
                Integer.parseInt(environment.getProperty("odoo.port")),
                environment.getProperty("odoo.db"),
                environment.getProperty("odoo.username"),
                environment.getProperty("odoo.password"));
        return session;
    }
}

