package com.dispatcher.service.model;

import com.dispatcher.service.base.entity.Auditable;
import com.dispatcher.service.odoo.api.Row;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Country implements Auditable {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "display_name")
    private String displayName;

    @JsonProperty(value = "currency_id")
    private Integer currencyId;

    @JsonProperty(value = "currency")
    private Currency currency;

    @JsonProperty(value = "phone_code")
    private Integer phoneCode;

    @JsonProperty(value = "state_ids")
    private List<Integer> stateIds;

    public static Country valueOf(Row row) {
        return builder()
                .id(row.getID())
                .code(String.valueOf(row.getFieldsOdoo().get("code")))
                .name(String.valueOf(row.getFieldsOdoo().get("name")))
                .displayName(String.valueOf(row.getFieldsOdoo().get("display_name")))
                .currencyId((Integer) (row.getFieldsOdoo().get("currency_id")))
                .phoneCode((Integer) (row.getFieldsOdoo().get("phone_code")))
                .stateIds((List<Integer>) (row.getFieldsOdoo().get("state_ids")))
                .build();
    }
}
