package com.dispatcher.gateway.config;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Data
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "keycloak-admin-client")
public class KeycloakProperties {

    @Getter(AccessLevel.NONE)
    private boolean initializeOnStartup;

    public boolean initializeOnStartup() {
        return initializeOnStartup;
    }

    @NotBlank
    @Value("${keycloak-admin-client.master-realm}")
    private String masterRealm;
    @Value("${keycloak-admin-client.application-realm}")
    private String applicationRealm;
    @Value("${keycloak-admin-client.client-id}")
    private String clientId;
    @Value("${keycloak-admin-client.client-secret}")
    private String clientSecret;
    @Value("${keycloak-admin-client.username}")
    private String username;
    @Value("${keycloak-admin-client.password}")
    private String password;
    @Value("${keycloak-admin-client.uri}")
    private String uri;

    private Integer connectionPoolSize = 16;
}
