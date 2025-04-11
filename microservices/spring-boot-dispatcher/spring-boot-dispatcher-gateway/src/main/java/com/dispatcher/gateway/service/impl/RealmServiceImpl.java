package com.dispatcher.gateway.service.impl;

import com.dispatcher.gateway.service.RealmService;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealmServiceImpl implements RealmService {

    private final Environment environment;

    public RealmServiceImpl(Environment environment) {
        this.environment = environment;
    }

    @Override
    public RealmRepresentation findById(Long id) {
        return null;
    }

    @Override
    public List<RealmRepresentation> findAll() {
        return null;
    }

    @Override
    public RealmRepresentation create(RealmRepresentation plan) {
        return null;
    }
}
