package com.dispatcher.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TestResourceNotFound extends RuntimeException {

    public TestResourceNotFound() {
        super();
    }

    public TestResourceNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public TestResourceNotFound(String message) {
        super(message);
    }

    public TestResourceNotFound(Throwable cause) {
        super(cause);
    }
}
