package com.dispatcher.inventory.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.dispatcher.inventory"})
public class InventoryConfiguration {

    private final Environment environment;

    InventoryConfiguration(Environment environment) {
        this.environment = environment;
    }
}

