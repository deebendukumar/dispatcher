package com.dispatcher.service.exception;

import org.ameba.i18n.Translator;

import java.io.Serializable;

public class BadRequestException extends DispatcherRuntimeException {

    /**
     * Create a new DataNotFoundException with a message text and the root
     * exception.
     *
     * @param message Message text as String
     * @param cause The root exception
     */
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Create a new DataNotFoundException with a message text.
     *
     * @param message Message text as String
     */
    public BadRequestException(String message) {
        super(message);
    }

    /**
     * Create a new DataNotFoundException with the id of the expected entity.
     *
     * @param id Id of the expected entity
     */
    public BadRequestException(Serializable id) {
        super(String.format("Entity class not found in persistence layer, id=[%s]",id));
    }

    public BadRequestException(Translator translator, String messageKey, Object... param) {
        super(translator.translate(messageKey, param), messageKey);
    }

}
