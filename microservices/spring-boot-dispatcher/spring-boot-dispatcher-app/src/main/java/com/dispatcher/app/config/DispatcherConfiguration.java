package com.dispatcher.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.dispatcher.app"})
public class DispatcherConfiguration {

    private final Environment environment;

    DispatcherConfiguration(Environment environment) {
        this.environment = environment;
    }
}

