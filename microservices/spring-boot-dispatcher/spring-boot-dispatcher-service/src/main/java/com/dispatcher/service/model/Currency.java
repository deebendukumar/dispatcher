package com.dispatcher.service.model;

import com.dispatcher.service.base.entity.Auditable;
import com.dispatcher.service.odoo.api.Row;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Currency implements Auditable {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "symbol")
    private String symbol;

    @JsonProperty(value = "rate")
    private Double rate;

    @JsonProperty(value = "active")
    private Boolean active;

    @JsonProperty(value = "display_name")
    private String displayName;

    public static Currency valueOf(Row row) {
        return builder()
                .id(row.getID())
                .name(String.valueOf(row.getFieldsOdoo().get("name")))
                .symbol(String.valueOf(row.getFieldsOdoo().get("symbol")))
                .rate((Double) (row.getFieldsOdoo().get("rate")))
                .active((Boolean) (row.getFieldsOdoo().get("active")))
                .displayName(String.valueOf(row.getFieldsOdoo().get("display_name")))
                .build();
    }
}
