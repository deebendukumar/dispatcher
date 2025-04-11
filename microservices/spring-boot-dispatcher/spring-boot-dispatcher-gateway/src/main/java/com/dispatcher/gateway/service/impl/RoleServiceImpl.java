package com.dispatcher.gateway.service.impl;

import com.dispatcher.gateway.domain.KeycloakAdapter;
import com.dispatcher.gateway.service.RoleService;
import org.keycloak.admin.client.resource.RoleResource;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final Environment environment;
    private final KeycloakAdapter keycloakAdapter;

    public RoleServiceImpl(Environment environment, KeycloakAdapter keycloakAdapter) {
        this.environment = environment;
        this.keycloakAdapter = keycloakAdapter;
    }

    @Override
    public RoleRepresentation findById(String id) {
        RolesResource rolesResource = findRealmRolesResource();
        RoleResource roleResource = rolesResource.get(id);
        return roleResource.toRepresentation();
    }

    @Override
    public List<RoleRepresentation> findAll() {
        RolesResource rolesResource = findRealmRolesResource();
        return rolesResource.list();
    }

    private RolesResource findRealmRolesResource() {
        return keycloakAdapter.findRealmRolesResource(environment.getProperty("keycloak-admin-client.application-realm"));
    }
}
