package com.dispatcher.gateway.model;

import com.dispatcher.service.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String id;
    private String realm;
    private String username;
    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String lastName;
    private String email;
    private String phone;
    private String password;

    //will be used to set attributes, value should be the origin of request
    //mobile
    //web
    //desktop
    private String origin;

    @JsonProperty(value = "realm_roles")
    private List<String> realmRoles;
}
