package com.dispatcher.gateway.service.impl;

import com.dispatcher.gateway.domain.KeycloakClientService;
import com.dispatcher.gateway.service.ApplicationService;
import com.dispatcher.gateway.document.Application;
import org.keycloak.representations.idm.ClientRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    private Environment environment;
    private KeycloakClientService clientService;

    public ApplicationServiceImpl(Environment environment, KeycloakClientService clientService) {
        this.environment = environment;
        this.clientService = clientService;
    }

    @Override
    public List<ClientRepresentation> findAll() {
        return clientService.findAll();
    }

    @Override
    public Application create(Application application) {
        return clientService.create(application);
    }

    @Override
    public Application update(String id, Application application) {
        return clientService.update(id, application);
    }

    @Override
    public List<String> findAllApplicationName() {
        return clientService.findAllApplicationName();
    }

    @Override
    public ClientRepresentation findById(String id) {
        return clientService.findById(id);
    }
}
