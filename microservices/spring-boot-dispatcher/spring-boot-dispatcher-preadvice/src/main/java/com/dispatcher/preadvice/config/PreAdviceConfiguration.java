package com.dispatcher.preadvice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.dispatcher.preadvice"})
public class PreAdviceConfiguration {

    private final Environment environment;

    PreAdviceConfiguration(Environment environment) {
        this.environment = environment;
    }
}

