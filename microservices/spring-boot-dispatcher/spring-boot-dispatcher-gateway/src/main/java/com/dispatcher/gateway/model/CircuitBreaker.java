package com.dispatcher.gateway.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CircuitBreaker {

    private String name;
    @JsonProperty(value = "fallback_uri")
    private String fallbackUri;
}
