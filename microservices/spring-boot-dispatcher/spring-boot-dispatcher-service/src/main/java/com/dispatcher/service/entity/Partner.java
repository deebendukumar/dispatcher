package com.dispatcher.service.entity;

import com.dispatcher.service.base.entity.BaseEntity;
import com.dispatcher.service.odoo.api.Row;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonPropertyOrder({
        "id",
        "name",
        "code",
        "contact"
})
@Data
@Builder
public class Partner extends BaseEntity {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "phone")
    private String phone;

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "contact")
    private Contact contact;

    @JsonProperty(value = "address")
    private Address address;

    public static Partner valueOf(Row row) {
        return builder()
                .build();
    }
}
