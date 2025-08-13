package com.dispatcher.pim.entity;

import com.dispatcher.common.base.BaseEntity;
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
@Document(collection = "hazmats")
public class Hazmat extends BaseEntity {

    @Field(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @Field(name = "description")
    @JsonProperty(value = "description")
    private String description;

    @Field(name = "body_html")
    @JsonProperty(value = "body_html")
    private String bodyHtml;

    public static Hazmat valueOf() {
        return builder()
                .build();
    }
}
