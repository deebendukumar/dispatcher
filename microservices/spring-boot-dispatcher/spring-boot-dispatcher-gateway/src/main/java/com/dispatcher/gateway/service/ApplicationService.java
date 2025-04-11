package com.dispatcher.gateway.service;

import com.dispatcher.gateway.document.Application;
import org.keycloak.representations.idm.ClientRepresentation;

import java.util.List;

public interface ApplicationService {

    ClientRepresentation findById(String id);
    List<ClientRepresentation> findAll();
    Application create(Application application);
    Application update(String id, Application application);
    List<String> findAllApplicationName();
}
