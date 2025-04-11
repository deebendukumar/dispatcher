package com.dispatcher.gateway.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Filter {

    @Field("add_request_header")
    @JsonProperty(value = "add_request_header")
    private String addRequestHeader;

    @Field("add_request_parameter")
    @JsonProperty(value = "add_request_parameter")
    private String addRequestParameter;

    @Field("add_response_header")
    @JsonProperty(value = "add_response_header")
    private String addResponseHeader;

    @Field("circuit_breaker")
    @JsonProperty(value = "circuit_breaker")
    private CircuitBreaker circuitBreaker;
}
