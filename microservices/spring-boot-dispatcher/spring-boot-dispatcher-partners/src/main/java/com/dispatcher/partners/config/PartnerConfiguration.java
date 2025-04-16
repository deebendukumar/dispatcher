package com.dispatcher.partners.config;

import org.ameba.i18n.AbstractSpringTranslator;
import org.ameba.i18n.Translator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.dispatcher.partners"})
public class PartnerConfiguration {

    private final Environment environment;

    PartnerConfiguration(Environment environment) {
        this.environment = environment;
    }
}

