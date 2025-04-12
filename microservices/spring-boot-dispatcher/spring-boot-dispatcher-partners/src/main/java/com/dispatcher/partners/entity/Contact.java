package com.dispatcher.partners.entity;

import com.dispatcher.service.base.entity.Auditable;
import com.dispatcher.service.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
public class Contact implements Auditable {

    @Field("phone")
    @JsonProperty(value = "phone")
    private String phone;

    @Field("email")
    @JsonProperty(value = "email")
    private String email;

    @Field("note")
    @JsonProperty(value = "note")
    private String note;

    public static Contact valueOf() {
        return builder()
                .build();
    }
}
