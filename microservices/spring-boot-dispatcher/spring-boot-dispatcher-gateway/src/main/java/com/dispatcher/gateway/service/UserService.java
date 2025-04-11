package com.dispatcher.gateway.service;

import com.dispatcher.gateway.model.User;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.core.Response;
import java.util.List;

public interface UserService {

    Response create(User user);
    UserRepresentation findById(String id);
    List<UserRepresentation> findAll();
    void logout(String id);
    UserRepresentation findByName(String name);
}
