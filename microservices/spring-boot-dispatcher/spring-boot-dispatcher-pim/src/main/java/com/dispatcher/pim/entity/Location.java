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
@Document(collection = "location")
public class Location extends BaseEntity {

    @Field(name = "warehouse_id")
    @JsonProperty(value = "warehouse_id")
    private String warehouseId;

    @Field(name = "zone_id")
    @JsonProperty(value = "zone_id")
    private String zoneId;

    @Field(name = "rack_id")
    @JsonProperty(value = "rack_id")
    private String rackId;

    @Field(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "dimension")
    private Dimension dimension;

    @Field(name = "active")
    @JsonProperty(value = "active")
    private Boolean active;

    @Field(name = "client_id")
    @JsonProperty(value = "client_id")
    private String clientId;

    public static Location valueOf() {
        return builder()
                .build();
    }
}
