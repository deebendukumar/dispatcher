package com.dispatcher.partners.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;

@Configuration
public class ApplicationConfig {

    private final Environment environment;

    ApplicationConfig(Environment environment) {
        this.environment = environment;
    }

    public
    @Bean
    MessageSource messageSource() {
        var nrrbm = new ResourceBundleMessageSource();
        nrrbm.setBasename("i18n");
        return nrrbm;
    }

}

