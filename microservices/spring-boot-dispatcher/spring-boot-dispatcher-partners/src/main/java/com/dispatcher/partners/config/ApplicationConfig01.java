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
public class ApplicationConfig01 {

    private final Environment environment;

    ApplicationConfig01(Environment environment) {
        this.environment = environment;
    }

    public
    @Bean
    Translator translator() {
        return new AbstractSpringTranslator() {
            @Override
            protected MessageSource getMessageSource() {
                return messageSource();
            }
        };
    }

    public
    @Bean
    MessageSource messageSource() {
        var nrrbm = new ResourceBundleMessageSource();
        nrrbm.setBasename("i18n");
        return nrrbm;
    }
}

