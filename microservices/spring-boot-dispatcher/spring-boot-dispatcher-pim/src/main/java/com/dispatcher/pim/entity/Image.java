package com.dispatcher.pim.entity;

import com.dispatcher.common.base.Auditable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@JsonPropertyOrder({
        "id"
})
@Data
@Builder
public class Image implements Auditable {

    @Field(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @Field(name = "src")
    @JsonProperty(value = "src")
    private String src;

    public static Image valueOf() {
        return builder()
                .build();
    }
}
