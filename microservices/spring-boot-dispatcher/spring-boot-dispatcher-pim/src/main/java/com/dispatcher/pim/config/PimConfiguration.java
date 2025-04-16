package com.dispatcher.pim.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.dispatcher.pim"})
public class PimConfiguration {

    private final Environment environment;

    PimConfiguration(Environment environment) {
        this.environment = environment;
    }
}

