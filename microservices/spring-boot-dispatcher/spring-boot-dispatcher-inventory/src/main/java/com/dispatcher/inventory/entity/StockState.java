package com.dispatcher.inventory.entity;

public class StockState {

	/**
	 * Stock is in incoming processes.<br>
	 * Not usable for ordinary outgoing operations.<br>
	 * Not synchronized with ERP.
	 */
	public static final int UNDEFINED = 0;

	/**
	 * Stock is in incoming processes.<br>
	 * Not usable for ordinary outgoing operations.<br>
	 * Not synchronized with ERP.
	 */
	public static final int INCOMING = 100;

	/**
	 * Normal store stock
	 */
	public static final int ON_STOCK = 300;

	/**
	 * Stock is picked for outgoing processing.<br>
	 */
	public static final int PICKED = 600;

	/**
	 * Stock is picked for outgoing processing.<br>
	 */
	public static final int PACKED = 650;

	/**
	 * Stock has left warehouse
	 */
	public static final int SHIPPED = 680;

	/**
	 * Can be removed
	 */
	public static final int DELETABLE = 1000;
}
