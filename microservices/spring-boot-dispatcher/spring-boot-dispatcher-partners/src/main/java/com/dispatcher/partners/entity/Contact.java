package com.dispatcher.partners.entity;

import com.dispatcher.service.base.entity.Auditable;
import com.dispatcher.service.base.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Contact implements Auditable {

    @Field("phone")
    private String phone;
    @Field("name")
    private String email;
    @Field("code")
    private String note;
}
