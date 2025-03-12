package com.dispatcher.service.http;

import com.dispatcher.service.exception.DispatcherRuntimeException;
import com.dispatcher.service.logging.LoggingCategories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;
import java.util.Locale;

public abstract class AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingCategories.PRESENTATION_LAYER_EXCEPTION);
    private static final String P_PRESENTATION_LAYER_EXCEPTION = "[P] Presentation Layer Exception: {}";

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(DispatcherRuntimeException.class)
    protected ResponseEntity<Response<?>> handleTechnicalRuntimeException(DispatcherRuntimeException tre) {
        logger.error(P_PRESENTATION_LAYER_EXCEPTION, tre.getLocalizedMessage(), tre);
        return new ResponseEntity<>(Response.newBuilder()
                .withMessage(tre.getMessage())
                .withMessageKey(tre.getMessageKey())
                .withHttpStatus(String.valueOf(HttpStatus.BAD_GATEWAY.value()))
                .withObj(tre.getData())
                .build(),
                HttpStatus.BAD_GATEWAY
        );
    }

    /**
     * Get the messageSource.
     *
     * @param key     The error code to search message text for
     * @param objects Any arguments that are passed into the message text
     * @return the messageSource.
     */
    protected String translate(String key, Object... objects) {
        return messageSource.getMessage(key, objects, Locale.getDefault());
    }

    /**
     * Build a response object that signals a not-okay response with a given status {@code code}.
     *
     * @param <T>    Some type extending the AbstractBase entity
     * @param code   The status code to set as response code
     * @param msg    The error message passed to the caller
     * @param msgKey The error message key passed to the caller
     * @param params A set of Serializable objects that are passed to the caller
     * @return A ResponseEntity with status {@code code}
     */
    protected <T extends Serializable> ResponseEntity<Response<T>> buildResponse(HttpStatus code, String msg, String msgKey, T... params) {
        Response result = Response.newBuilder().withMessage(msg).withMessageKey(msgKey).withHttpStatus(code.toString()).withObj(params).build();
        return new ResponseEntity<>(result, code);
    }

    /**
     * Build a response object that signals a not-okay response with a given status {@code code} and with given http headers.
     *
     * @param <T>     Some type extending the AbstractBase entity
     * @param code    The status code to set as response code
     * @param msg     The error message passed to the caller
     * @param msgKey  The error message key passed to the caller
     * @param headers The map of headers.
     * @param params  A set of Serializable objects that are passed to the caller
     * @return A ResponseEntity with status {@code code}
     */
    protected <T extends Serializable> ResponseEntity<Response<T>> buildResponse(HttpStatus code, String msg, String msgKey, MultiValueMap<String, String> headers, T... params) {
        Response result = Response.newBuilder().withMessage(msg).withMessageKey(msgKey).withHttpStatus(code.toString()).withObj(params).build();
        return new ResponseEntity<>(result, headers, code);
    }

    /**
     * Build an response object that signals a success response to the caller.
     *
     * @param <T>    Some type extending the AbstractBase entity
     * @param params A set of Serializable objects that are passed to the caller
     * @return A ResponseEntity with status {@link HttpStatus#OK}
     */
    protected <T extends Serializable> ResponseEntity<Response<T>> buildOKResponse(T... params) {
        return buildResponse(HttpStatus.OK, "", "", params);
    }

    /**
     * Build a response object that signals a not-okay response with a given status {@code code}.
     *
     * @param <T> Some type extending the AbstractBase entity
     * @param code The status code to set as response code
     * @param msg The error message passed to the caller
     * @param msgKey The error message key passed to the caller
     * @param params A set of Serializable objects that are passed to the caller
     * @return A ResponseEntity with status {@code code}
     */
    protected <T extends Serializable> ResponseEntity<Response<T>> buildNOKResponseWithKey(HttpStatus code, String msg, String msgKey, T... params) {
        return buildResponse(code, msg, msgKey, params);
    }

    /**
     * Build a response object that signals a not-okay response with a given status {@code code}.
     *
     * @param <T> Some type extending the AbstractBase entity
     * @param code The status code to set as response code
     * @param msg The error message passed to the caller
     * @param params A set of Serializable objects that are passed to the caller
     * @return A ResponseEntity with status {@code code}
     */
    protected <T extends Serializable> ResponseEntity<Response<T>> buildNOKResponse(HttpStatus code, String msg, T... params) {
        return buildResponse(code, msg, "", params);
    }
}
