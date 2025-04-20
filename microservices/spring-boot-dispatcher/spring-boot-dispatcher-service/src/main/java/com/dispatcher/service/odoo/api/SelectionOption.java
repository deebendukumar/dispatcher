package com.dispatcher.service.odoo.api;

/**
 * Holds selection options for Field(s) in a FieldCollection if the field is a selection field.
 */
public class SelectionOption {
	public final String code;
	public final String value;
	
	/**
	 * Default constructor
	 * @param code
	 * @param value
	 */
	public SelectionOption(final String code, final String value){
		this.code = code;
		this.value = value;
	}
}
