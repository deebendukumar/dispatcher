package com.dispatcher.gateway.initializer;

import com.dispatcher.gateway.config.KeycloakProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * InitializingBean is a Spring interface that can be used to perform custom initialization logic for a bean.
 * It has a single method, afterPropertiesSet(), which is called after all of the bean's properties have been set.
 */
@Service
public class KeycloakInitializer implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(KeycloakInitializer.class);

    private final KeycloakProperties properties;
    private final ObjectMapper mapper;

    public KeycloakInitializer(KeycloakProperties properties, ObjectMapper mapper) {
        this.properties = properties;
        this.mapper = mapper;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
