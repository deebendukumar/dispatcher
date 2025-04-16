package com.dispatcher.preadvice.entity;

import com.dispatcher.service.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@JsonPropertyOrder({
        "id"
})
@Data
@Builder
@Document(collection = "pre_advice")
public class PreAdvice extends BaseEntity {

    @Field(name = "order_number")
    @JsonProperty(value = "order_number")
    private String orderNumber;

    @Field(name = "external_number")
    @JsonProperty(value = "external_number")
    private String externalNumber;

    @Field(name = "external_id")
    @JsonProperty(value = "external_id")
    private String externalId;

    @Field(name = "order_state")
    @JsonProperty(value = "order_state")
    private Integer orderState = OrderState.UNDEFINED;

    @Field(name = "started")
    @JsonProperty(value = "started")
    private Date started;

    @Field(name = "finished")
    @JsonProperty(value = "finished")
    private Date finished;

    @Field(name = "lines")
    @JsonProperty(value = "lines")
    private List<PreAdviceLine> lines;

    @Field(name = "sender_name")
    @JsonProperty(value = "sender_name")
    private String senderName;

    @Field(name = "carrier_name")
    @JsonProperty(value = "carrier_name")
    private String carrierName;

    @Field(name = "delivery_date")
    @JsonProperty(value = "delivery_date")
    private Date deliveryDate;

    public static PreAdvice valueOf() {
        return builder()
                .build();
    }
}
