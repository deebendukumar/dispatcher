package com.dispatcher.service.entity;

import com.dispatcher.service.base.entity.Auditable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
public class Address implements Auditable {

    @JsonProperty(value = "street")
    private String street;

    @JsonProperty(value = "street")
    private String street2;

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "state")
    private String state;

    @JsonProperty(value = "country")
    private String country;

    @JsonProperty(value = "country_id")
    private Integer countryId;


    @JsonProperty(value = "zip")
    private String zip;

    public static Address valueOf() {
        return builder()
                .build();
    }
}
