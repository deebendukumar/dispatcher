package com.dispatcher.gateway.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private String id;
    @JsonProperty(value = "client_id")
    private String clientId;
    private String name;
    protected String description;
    @JsonProperty(value = "root_url")
    protected String rootUrl;
    @JsonProperty(value = "admin_url")
    protected String adminUrl;
    @JsonProperty(value = "base_url")
    protected String baseUrl;
    protected Boolean enabled;
}
