package com.dispatcher.gateway.config;

import com.dispatcher.gateway.security.AuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Profile("!dev")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private Environment environment;
    private AuthenticationProvider provider;

    public SecurityConfiguration() {
    }

    private static final RequestMatcher UNPROTECTED_URLS = new AndRequestMatcher(
            new AntPathRequestMatcher("/tokens/**")
    );

    private static final RequestMatcher PROTECTED_URLS = new AndRequestMatcher(
            new AntPathRequestMatcher("/**")
    );

    public SecurityConfiguration(Environment environment, final AuthenticationProvider authenticationProvider) {
        super();
        this.environment = environment;
        this.provider = authenticationProvider;
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf((csrf) -> csrf.disable());
        httpSecurity.cors(cors -> cors.disable());
        httpSecurity.authorizeHttpRequests((authz) -> authz
                .requestMatchers(PROTECTED_URLS).authenticated())
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return httpSecurity.build();
    }
}
