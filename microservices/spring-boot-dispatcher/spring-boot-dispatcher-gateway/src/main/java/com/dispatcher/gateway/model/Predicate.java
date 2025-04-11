package com.dispatcher.gateway.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Predicate {

    private String method;
    private String cookie;

    @Field("after_route")
    @JsonProperty(value = "after_route")
    private String afterRoute;

    @Field("before_route")
    @JsonProperty(value = "before_route")
    private String beforeRoute;

    private String header;
    private String query;

    @Field("remote_address")
    @JsonProperty(value = "remote_address")
    private String remoteAddress;
}
