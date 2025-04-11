package com.dispatcher.gateway.config;

import com.dispatcher.gateway.service.ApiRouteService;
import com.dispatcher.gateway.service.impl.ApiRouteLocatorImpl;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Profile("!dev")
@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class GatewayConfiguration {

    private static final String[] AUTH_WHITELIST = {
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**"
    };

    private Environment environment;
    private final ApplicationProperties applicationProperties;

    public GatewayConfiguration(Environment environment, ApplicationProperties applicationProperties) {
        this.environment = environment;
        this.applicationProperties = applicationProperties;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http.csrf(ServerHttpSecurity.CsrfSpec::disable);
        //http.cors().disable();
        //http.oauth2Login();
        http.authorizeExchange().pathMatchers(AUTH_WHITELIST).permitAll();
        http.authorizeExchange().anyExchange().authenticated();
        http.oauth2ResourceServer().jwt();
        return http.build();
    }

    @Bean
    public RouteLocator routeLocator(ApiRouteService apiRouteService, RouteLocatorBuilder routeLocatorBuilder) {
        return new ApiRouteLocatorImpl(environment,
                applicationProperties,
                apiRouteService,
                routeLocatorBuilder);
    }
}