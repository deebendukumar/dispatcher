package com.dispatcher.gateway.domain.exception;

import com.dispatcher.gateway.exception.ApplicationException;

public class ClientNotFoundException extends ApplicationException {

    public ClientNotFoundException(String id, Integer status, String detail) {
        super(status, "client '" + id + "' not found (response: status='" + status + "', detail='" + detail + "')");
    }
}
