package com.dispatcher.partners.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@ComponentScan(basePackages = {"com.dispatcher.partners"})
public class PartnerConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(PartnerConfiguration.class);

    private final Environment environment;

    PartnerConfiguration(Environment environment) {
        this.environment = environment;
        logger.info("Into PartnerConfiguration");
    }
}

