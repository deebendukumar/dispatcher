package com.dispatcher.service.odoo.api;

/**
 * Exception class for Odoo API errors
 */
public class OdooApiException extends Exception {

	private static final long serialVersionUID = 3148147969903379455L;

	public OdooApiException(String message) {
		super(message);
	}

	public OdooApiException(Throwable cause) {
		super(cause);
	}

	public OdooApiException(String message, Throwable cause) {
		super(message, cause);
	}

}
