package com.dispatcher.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DispatcherConfiguration {

    private final Environment environment;

    DispatcherConfiguration(Environment environment) {
        this.environment = environment;
    }
}

