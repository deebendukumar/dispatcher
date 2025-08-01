package com.dispatcher.service.model;

public enum PartnerStatus {

    UNDEFINED(10),
    ACTIVE(20),
    INACTIVE(20);

    private final int status;

    PartnerStatus(int status) {
        this.status = status;
    }

    /**
     * Get the order.
     *
     * @return the order.
     */
    public int getStatus() {
        return status;
    }
}
