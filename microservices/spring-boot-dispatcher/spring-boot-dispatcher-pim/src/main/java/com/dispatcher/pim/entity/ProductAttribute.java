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
public class ProductAttribute {

    @Field(name = "product_id")
    @JsonProperty(value = "product_id")
    private String productId;

    @Field(name = "attribute_id")
    @JsonProperty(value = "attribute_id")
    private String attributeId;

    public static ProductAttribute valueOf() {
        return builder()
                .build();
    }
}
