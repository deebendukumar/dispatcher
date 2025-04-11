package com.dispatcher.gateway.config;

import com.dispatcher.gateway.document.ApiRoute;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.apim")
public class ApplicationProperties {

    private List<ApiRoute> routes = new ArrayList<>();
}
