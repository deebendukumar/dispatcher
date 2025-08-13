package com.dispatcher.preadvice.entity;

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
@Document(collection = "pre_advice")
public class PreAdviceLine extends BaseEntity {

    @Field(name = "order_number")
    @JsonProperty(value = "order_number")
    private String orderNumber;

    @Field(name = "line_number")
    @JsonProperty(value = "line_number")
    private String lineNumber;

    @Field(name = "variant_id")
    @JsonProperty(value = "variant_id")
    private String variantId;

    @Field(name = "batch_number")
    @JsonProperty(value = "batch_number")
    private String batchNumber;

    @Field(name = "amount")
    @JsonProperty(value = "amount")
    private BigDecimal amount;  //The advised amount

    @Field(name = "confirmed_amount")
    @JsonProperty(value = "confirmed_amount")
    private BigDecimal confirmedAmount;  //The advised amount

    public static PreAdviceLine valueOf() {
        return builder()
                .build();
    }
}
