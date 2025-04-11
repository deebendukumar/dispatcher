package com.dispatcher.gateway.domain;

import com.dispatcher.gateway.config.KeycloakProperties;
import com.dispatcher.gateway.model.Role;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeycloakRoleService {

    private static final Logger logger = LoggerFactory.getLogger(KeycloakRoleService.class);

    private KeycloakAdapter keycloakAdapter;
    private KeycloakProperties keycloakProperties;

    public KeycloakRoleService(KeycloakProperties keycloakProperties, KeycloakAdapter keycloakAdapter) {
        this.keycloakProperties = keycloakProperties;
        this.keycloakAdapter = keycloakAdapter;
    }

    /**
     * This will list down all the roles that belongs to a realm
     *
     * @return
     */
    public List<Role> getRoles() {
        List<Role> list = new ArrayList<>();
        RolesResource rolesResource = keycloakAdapter.findRealmRolesResource(keycloakProperties.getApplicationRealm());
        List<RoleRepresentation> clients = rolesResource.list();
        if (!clients.isEmpty()) {
            list = clients.stream()
                    .map(roleRepresentation -> new Role(
                            roleRepresentation.getId(),
                            roleRepresentation.getName(),
                            roleRepresentation.getDescription()))
                    .collect(Collectors.toList());
        }
        return list;
    }
}
