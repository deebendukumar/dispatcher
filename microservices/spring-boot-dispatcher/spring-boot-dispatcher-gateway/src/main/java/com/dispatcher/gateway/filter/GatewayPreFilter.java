package com.dispatcher.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class GatewayPreFilter implements GatewayFilter {

    private static final Logger logger = LoggerFactory.getLogger(GatewayPreFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        headers.entrySet().forEach(entry -> {
            logger.info(entry.getKey() + " " + Arrays.toString(entry.getValue().toArray()));
        });
        exchange.getResponse().setStatusCode(HttpStatus.OK);
        return chain.filter(exchange);
    }
}
