package com.dispatcher.gateway.domain.exception;

import com.dispatcher.gateway.exception.ApplicationException;

public class UserCreationFailedException extends ApplicationException {

    public UserCreationFailedException(String username, Integer status, String detail) {
        super(status, "Unable to create user '" + username + "' on keycloak (response: status='" + status + "', detail='" + detail + "')");
    }
}
