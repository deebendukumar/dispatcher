package com.dispatcher.gateway.model;

import com.dispatcher.service.base.entity.Auditable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endpoint implements Auditable {

    @Field("base_uri")
    @JsonProperty(value = "base_uri")
    private String baseUri;

    @Field("context")
    @JsonProperty(value = "context")
    private String context;

    @Field("version")
    @JsonProperty(value = "version")
    private String version;
}
