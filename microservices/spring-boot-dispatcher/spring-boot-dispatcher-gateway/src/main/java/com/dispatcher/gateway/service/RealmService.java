package com.dispatcher.gateway.service;

import org.keycloak.representations.idm.RealmRepresentation;

import java.util.List;

public interface RealmService {
    RealmRepresentation findById(Long id);
    List<RealmRepresentation> findAll();
    RealmRepresentation create(RealmRepresentation plan);
}
