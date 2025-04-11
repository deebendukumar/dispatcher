package com.dispatcher.gateway.domain.exception;

import com.dispatcher.gateway.exception.ApplicationException;

public class KeycloakInternalError extends ApplicationException {

    public KeycloakInternalError(String username, Integer status, String detail) {
        super(status, "Internal error '" + username + "' on keycloak (response: status='" + status + "', detail='" + detail + "')");
    }
}
