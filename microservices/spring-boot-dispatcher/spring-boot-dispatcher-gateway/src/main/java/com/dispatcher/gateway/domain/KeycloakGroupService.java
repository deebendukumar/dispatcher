package com.dispatcher.gateway.domain;

import com.dispatcher.gateway.config.KeycloakProperties;
import com.dispatcher.gateway.model.Group;
import org.keycloak.admin.client.resource.GroupsResource;
import org.keycloak.representations.idm.GroupRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeycloakGroupService {

    private static final Logger logger = LoggerFactory.getLogger(KeycloakGroupService.class);

    private KeycloakAdapter keycloakAdapter;
    private KeycloakProperties keycloakProperties;

    public KeycloakGroupService(KeycloakProperties keycloakProperties, KeycloakAdapter keycloakAdapter) {
        this.keycloakProperties = keycloakProperties;
        this.keycloakAdapter = keycloakAdapter;
    }

    public List<Group> getGroups() {
        List<Group> list = new ArrayList<>();
        GroupsResource groupsResource = keycloakAdapter.findGroupsResource(keycloakProperties.getApplicationRealm());
        List<GroupRepresentation> clients = groupsResource.groups();
        if (!clients.isEmpty()) {
            list = clients.stream()
                    .map(groupRepresentation -> new Group(
                            groupRepresentation.getId(),
                            groupRepresentation.getName()))
                    .collect(Collectors.toList());
        }
        return list;
    }
}
