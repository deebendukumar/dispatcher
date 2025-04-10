package com.dispatcher.partners.data;

import com.dispatcher.service.integration.ApplicationEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
public class Contact extends ApplicationEntity implements Serializable {

    @Id
    private String phone;
    @Field("name")
    private String email;
    @Field("code")
    private String note;
}
