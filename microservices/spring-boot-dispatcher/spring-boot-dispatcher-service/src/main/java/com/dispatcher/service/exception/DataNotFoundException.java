package com.dispatcher.service.exception;

import java.io.Serializable;

public class DataNotFoundException extends DispatcherRuntimeException {

    /**
     * Create a new DataNotFoundException with a message text and the root
     * exception.
     *
     * @param message Message text as String
     * @param cause The root exception
     */
    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Create a new DataNotFoundException with a message text.
     *
     * @param message Message text as String
     */
    public DataNotFoundException(String message) {
        super(message);
    }

    /**
     * Create a new DataNotFoundException with the id of the expected entity.
     *
     * @param id Id of the expected entity
     */
    public DataNotFoundException(Serializable id) {
        super(String.format("Entity class not found in persistence layer, id=[%s]",id));
    }
}
