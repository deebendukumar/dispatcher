package com.dispatcher.gateway.document;

import com.dispatcher.service.integration.ApplicationEntity;
import com.dispatcher.service.integration.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application extends BaseEntity {

    private String id;
    private String name;
    private String description;
    @JsonProperty(value = "root-url")
    private String rootUrl;
    @JsonProperty(value = "admin-url")
    private String adminUrl;
    @JsonProperty(value = "base-url")
    private String baseUrl;
    private Boolean enabled;
}
