package com.dispatcher.pim.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@JsonPropertyOrder({
        "id",
        "name"
})
@Data
@Builder
@Document(collection = "product_attribute_type")
public class ProductAttributeType {

    @Field(name = "name")
    @JsonProperty(value = "name")
    private String name;

    public static ProductAttributeType valueOf() {
        return builder()
                .build();
    }

}
