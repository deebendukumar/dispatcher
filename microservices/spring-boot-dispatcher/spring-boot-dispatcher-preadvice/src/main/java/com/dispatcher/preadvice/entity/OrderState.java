package com.dispatcher.preadvice.entity;

public class OrderState {

    /**
     * Order is not ready to be handled. Used within creation processes.
     */
    public static final int UNDEFINED = 0;

    /**
     * Order is ready created.
     */
    public static final int CREATED = 50;

    /**
     * Order is ready for automatic pre-processing
     */
    public static final int RELEASED = 100;

    /**
     * Processing is interrupted.
     */
    public static final int PAUSE = 200;

    /**
     * Can be processed
     */
    public static final int PROCESSABLE = 300;

    /**
     * Reserved for a user to process
     */
    public static final int RESERVED = 400;

    /**
     * Processing has been started.
     */
    public static final int STARTED = 500;

    /**
     * The order is not finished, but can not be continued at the moment.
     */
    public static final int PENDING = 550;

    /**
     * All picks are done.
     */
    public static final int PICKED = 600;

    /**
     * Package can be started
     */
    public static final int PACKING = 640;

    /**
     * All package is done
     */
    public static final int PACKED = 650;

    /**
     * Shipping can be started
     */
    public static final int SHIPPING = 670;

    /**
     * Shipping is done
     */
    public static final int SHIPPED = 680;

    /**
     * The order has been finished completely.
     */
    public static final int FINISHED = 700;

    /**
     * For some reasons the order failed.
     */
    public static final int FAILED = 710;

    /**
     * The order has been canceled
     */
    public static final int CANCELED = 800;

    /**
     * The operation is done and possible post processing actions have been done.
     */
    public static final int POSTPROCESSED = 900;

    /**
     * The order can be deleted.
     */
    public static final int DELETABLE = 1000;
}

