package com.dispatcher.partners.data;

import com.dispatcher.service.integration.BaseEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Contact extends BaseEntity {

    @Id
    private String phone;
    @Field("name")
    private String email;
    @Field("code")
    private String note;
}
