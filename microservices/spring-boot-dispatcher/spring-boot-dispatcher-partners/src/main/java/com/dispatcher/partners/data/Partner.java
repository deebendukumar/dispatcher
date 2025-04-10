package com.dispatcher.partners.data;

import com.dispatcher.service.integration.ApplicationEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Document(collection = "partners")
public class Partner extends ApplicationEntity implements Serializable {

    @Field("name")
    private String name;
    @Field("code")
    private String code;

    private Contact contact;
}
