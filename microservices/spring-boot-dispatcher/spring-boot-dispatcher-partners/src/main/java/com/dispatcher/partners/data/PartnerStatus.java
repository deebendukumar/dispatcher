package com.dispatcher.partners.data;

public enum PartnerStatus {

    CREATED(10),
    INITIALIZED(20);

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
