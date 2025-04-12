package com.dispatcher.partners.entity;

import com.dispatcher.service.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@JsonPropertyOrder({
        "id",
        "name",
        "code",
        "contact"
})
@Data
@Builder
@Document(collection = "partners")
public class Partner extends BaseEntity {

    @Field("name")
    @JsonProperty(value = "name")
    private String name;

    @Field("code")
    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "contact")
    private Contact contact;

    public static Partner valueOf() {
        return builder()
                .build();
    }
}
