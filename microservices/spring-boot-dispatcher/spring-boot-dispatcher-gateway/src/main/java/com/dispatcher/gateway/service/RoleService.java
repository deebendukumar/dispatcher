package com.dispatcher.gateway.service;

import org.keycloak.representations.idm.RoleRepresentation;

import java.util.List;

public interface RoleService {

    RoleRepresentation findById(String id);
    List<RoleRepresentation> findAll();
}
