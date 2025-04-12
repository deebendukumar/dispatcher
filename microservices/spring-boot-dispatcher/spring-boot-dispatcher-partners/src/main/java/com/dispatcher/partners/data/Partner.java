package com.dispatcher.partners.data;

import com.dispatcher.service.integration.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "partners")
public class Partner extends BaseEntity {

    @Field("name")
    private String name;
    @Field("code")
    private String code;

    private Contact contact;
}
