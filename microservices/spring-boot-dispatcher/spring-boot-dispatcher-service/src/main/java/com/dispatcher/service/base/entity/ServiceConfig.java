package com.dispatcher.service.base.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@JsonPropertyOrder({
        "id"
})
@Data
@Builder
@Document(collection = "service_config")
public class ServiceConfig extends BaseEntity {

    @Field(name = "version")
    @JsonProperty(value = "version")
    private Integer version;

    @Field(name = "client_id")
    @JsonProperty(value = "client_id")
    private String clientId;

    @Field(name = "useforgoodsin")
    @JsonProperty(value = "useforgoodsin")
    private Boolean useforgoodsin;

    @Field(name = "useforgoodsout")
    @JsonProperty(value = "useforgoodsout")
    private Boolean useforgoodsout;

    @Field(name = "useforpicking")
    @JsonProperty(value = "useforpicking")
    private Boolean useforpicking;

    @Field(name = "useforreplenish")
    @JsonProperty(value = "useforreplenish")
    private Boolean useforreplenish;

    @Field(name = "useforstorage")
    @JsonProperty(value = "useforstorage")
    private Boolean useforstorage;

    @Field(name = "usefortransfer")
    @JsonProperty(value = "usefortransfer")
    private Boolean usefortransfer;

    public static ServiceConfig valueOf() {
        return builder()
                .build();
    }
}
