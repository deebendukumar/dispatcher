package com.dispatcher.service.entity;

import com.dispatcher.service.base.entity.Auditable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
public class Address implements Auditable {

    @Field("street")
    @JsonProperty(value = "street")
    private String street;

    @Field("city")
    @JsonProperty(value = "city")
    private String city;

    @Field("state")
    @JsonProperty(value = "state")
    private String state;

    @Field("country")
    @JsonProperty(value = "country")
    private String country;

    @Field("zip")
    @JsonProperty(value = "zip")
    private String zip;

    public static Address valueOf() {
        return builder()
                .build();
    }
}
