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
public class ProductAttributeValue {

    @Field(name = "product_attribute_id")
    @JsonProperty(value = "product_attribute_id")
    private String productAttributeId;

    @Field(name = "value")
    @JsonProperty(value = "value")
    private String value;

    public static ProductAttributeValue valueOf() {
        return builder()
                .build();
    }
}
