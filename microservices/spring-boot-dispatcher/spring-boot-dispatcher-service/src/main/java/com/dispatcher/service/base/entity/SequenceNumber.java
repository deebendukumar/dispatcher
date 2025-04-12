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
@Document(collection = "sequence_number")
public class SequenceNumber extends BaseEntity {

    @Field(name = "classname")
    @JsonProperty(value = "classname")
    private String classname;

    @Field(name = "sequence_number")
    @JsonProperty(value = "sequence_number")
    private BigInteger sequenceNumber;

    @Field(name = "version")
    @JsonProperty(value = "version")
    private Integer version;

    public static SequenceNumber valueOf() {
        return builder()
                .build();
    }
}
