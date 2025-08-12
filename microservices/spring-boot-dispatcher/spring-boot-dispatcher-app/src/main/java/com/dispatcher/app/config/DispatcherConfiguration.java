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

}

