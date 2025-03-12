package com.dispatcher.service.logging;

public class LoggingCategories {

    /** Category to log all errors thrown in the presentation layer. */
    public static final String PRESENTATION_LAYER_EXCEPTION = "PRESENTATION_LAYER_EXCEPTION";
    /** Category to log all errors thrown in the business layer. */
    public static final String SERVICE_LAYER_EXCEPTION = "SERVICE_LAYER_EXCEPTION";
    /** Category to log all errors thrown in the integration layer. */
    public static final String INTEGRATION_LAYER_EXCEPTION = "INTEGRATION_LAYER_EXCEPTION";
    /** Category to log time consumption of operations performed within the service layer. */
}
