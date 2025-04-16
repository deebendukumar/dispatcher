package com.dispatcher.partners.entity;

import com.dispatcher.service.base.entity.Auditable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
public class Address implements Auditable {

    @Field("first_name")
    @JsonProperty(value = "first_name")
    private String firstName;

    @Field("last_name")
    @JsonProperty(value = "last_name")
    private String lastName;

    @Field("company")
    @JsonProperty(value = "company")
    private String company;

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

    @Field("zip_code")
    @JsonProperty(value = "zip_code")
    private String zipCode;

    public static Address valueOf() {
        return builder()
                .build();
    }
}
