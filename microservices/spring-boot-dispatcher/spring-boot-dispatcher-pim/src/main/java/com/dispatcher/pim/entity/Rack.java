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
@Document(collection = "racks")
public class Rack extends BaseEntity {

    @Field(name = "warehouse_id")
    @JsonProperty(value = "warehouse_id")
    private String warehouseId;

    @Field(name = "zone_id")
    @JsonProperty(value = "zone_id")
    private String zoneId;

    @Field(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @Field(name = "active")
    @JsonProperty(value = "active")
    private Boolean active;

    public static Rack valueOf() {
        return builder()
                .build();
    }
}
