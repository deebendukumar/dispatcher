package com.dispatcher.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.dispatcher.partners"})
public class CommonConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(CommonConfiguration.class);

    private final Environment environment;

    CommonConfiguration(Environment environment) {
        this.environment = environment;
        logger.info("Into PartnerConfiguration");
    }


}

