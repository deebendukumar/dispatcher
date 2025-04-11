package com.dispatcher.gateway.domain.exception;

import com.dispatcher.gateway.exception.ApplicationException;

public class UserNameExtractException extends ApplicationException {

    public UserNameExtractException(Integer status, String detail) {
        super(status, "Unable to extract user from token (response: status='" + status + "', detail='" + detail + "')");
    }
}
