package com.dispatcher.gateway.domain.exception;

import com.dispatcher.gateway.exception.ApplicationException;

public class UserNotFoundException extends ApplicationException {

    public UserNotFoundException(String username, Integer status, String detail) {
        super(status, "Unable to find user '" + username + "' on keycloak (response: status='" + status + "', detail='" + detail + "')");
    }
}
