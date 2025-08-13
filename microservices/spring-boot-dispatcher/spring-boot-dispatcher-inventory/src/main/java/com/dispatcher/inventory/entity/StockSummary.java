package com.dispatcher.inventory.entity;

import com.dispatcher.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@JsonPropertyOrder({
        "id"
})
@Data
@Builder
@Document(collection = "stock_summary")
public class StockSummary extends BaseEntity {

    @Field(name = "variant_id")
    @JsonProperty(value = "variant_id")
    private String variantId;

    @Field(name = "quantity")
    @JsonProperty(value = "quantity")
    private BigDecimal quantity;

    public static StockSummary valueOf() {
        return builder()
                .build();
    }

}
