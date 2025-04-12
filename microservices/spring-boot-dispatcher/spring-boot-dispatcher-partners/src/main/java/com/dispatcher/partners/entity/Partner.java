package com.dispatcher.partners.entity;

import com.dispatcher.service.base.entity.BaseEntity;
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
    private String name;
    @Field("code")
    private String code;

    private Contact contact;
}
