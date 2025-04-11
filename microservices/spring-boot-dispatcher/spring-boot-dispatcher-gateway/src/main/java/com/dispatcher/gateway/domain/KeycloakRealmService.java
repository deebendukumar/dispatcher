package com.dispatcher.gateway.domain;

import com.dispatcher.gateway.model.Realm;
import org.keycloak.representations.idm.RealmRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeycloakRealmService {

    private static final Logger logger = LoggerFactory.getLogger(KeycloakRealmService.class);

    private KeycloakAdapter keycloakAdapter;

    public KeycloakRealmService(KeycloakAdapter keycloakAdapter) {
        this.keycloakAdapter = keycloakAdapter;
    }

    public List<Realm> getRealms() {
        List<Realm> realmNames = new ArrayList<>();
        List<RealmRepresentation> realms = keycloakAdapter.findAll();
        if (!realms.isEmpty()) {
            realmNames = realms.stream().map(RealmRepresentation::getRealm).map(Realm::fromValue).collect(Collectors.toList());
        }
        return realmNames;
    }

}
