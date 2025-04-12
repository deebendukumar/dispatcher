package com.dispatcher.pim.entity;

import com.dispatcher.service.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@JsonPropertyOrder({
        "id",
        "name",
        "body",
        "body_html"
})
@Data
@Builder
@Document(collection = "warehouses")
public class Warehouse extends BaseEntity {

    @Field(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @Field(name = "location")
    @JsonProperty(value = "location")
    private String location;

    @Field(name = "active")
    @JsonProperty(value = "active")
    private Boolean active;

    public static Warehouse valueOf() {
        return builder()
                .build();
    }
}
