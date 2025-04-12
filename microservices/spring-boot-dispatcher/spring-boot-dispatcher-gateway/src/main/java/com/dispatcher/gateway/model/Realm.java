package com.dispatcher.gateway.model;

import com.dispatcher.service.base.entity.BaseEntity;

import static org.apache.commons.lang3.Validate.notBlank;

public class Realm extends BaseEntity {

    private String value;

    private Realm(String value) {
        this.value = value;
    }

    protected Realm() {
        super();
        // for framework
    }

    public static Realm fromValue(String realmName) {
        notBlank(realmName, "realmName may not be blank");
        return new Realm(realmName);
    }
}
