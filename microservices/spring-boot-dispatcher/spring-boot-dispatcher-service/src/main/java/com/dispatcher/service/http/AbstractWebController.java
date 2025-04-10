package com.dispatcher.service.http;

import com.dispatcher.service.logging.LoggingCategories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public abstract class AbstractWebController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingCategories.PRESENTATION_LAYER_EXCEPTION);
    private static final String P_PRESENTATION_LAYER_EXCEPTION = "[P] Presentation Layer Exception: {}";

    @Autowired
    private MessageSource messageSource;

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
}
