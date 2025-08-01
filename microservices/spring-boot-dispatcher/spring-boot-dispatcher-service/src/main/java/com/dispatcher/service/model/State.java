package com.dispatcher.service.model;

import com.dispatcher.service.base.entity.Auditable;
import com.dispatcher.service.odoo.api.Row;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class State implements Auditable {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "display_name")
    private String displayName;

    @JsonProperty(value = "country_id")
    private Integer countryId;

    public static State valueOf(Row row) {
        return builder()
                .id(row.getID())
                .code(String.valueOf(row.getFieldsOdoo().get("code")))
                .name(String.valueOf(row.getFieldsOdoo().get("name")))
                .displayName(String.valueOf(row.getFieldsOdoo().get("display_name")))
                .countryId((Integer) (row.getFieldsOdoo().get("country_id")))
                .build();
    }
}
