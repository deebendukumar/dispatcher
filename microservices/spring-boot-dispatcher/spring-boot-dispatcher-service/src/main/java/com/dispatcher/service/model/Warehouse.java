package com.dispatcher.service.model;

import com.dispatcher.common.base.Auditable;
import com.dispatcher.odoo.Row;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Warehouse implements Auditable {

    @JsonProperty(value = "id")
    private Integer id;

    /**
     * mandatory fields
     */
    @JsonProperty(value = "active")
    private Boolean active = true;
    @JsonProperty(value = "code")
    @Size(min = 6, max = 6, message = "Name must be 6 characters")
    private String code;
    @JsonProperty(value = "name")
    @NotNull(message = "Name cannot be empty or null")
    private String name;



    @JsonProperty(value = "company_id")
    private Integer companyId;

    @JsonProperty(value = "partner_id")
    private Integer partnerId;

    @JsonProperty(value = "display_name")
    private String displayName;

    @JsonProperty(value = "lot_stock_id")
    private int lotStockId;

    @JsonProperty(value = "wh_pack_stock_loc_id")
    private Integer whPackStockLocId;

    @JsonProperty(value = "crossdock_route_id")
    private Integer crossdockRouteId;

    @JsonProperty(value = "delivery_route_id")
    private Integer deliveryRouteId;

    @JsonProperty(value = "pack_type_id")
    private Integer packTypeId;

    @JsonProperty(value = "pick_type_id")
    private Integer pickTypeId;

    @JsonProperty(value = "reception_steps")
    private String receptionSteps;

    @JsonProperty(value = "in_type_id")
    private Integer inTypeId;

    @JsonProperty(value = "reception_route_id")
    private Integer receptionRouteId;

    @JsonProperty(value = "wh_output_stock_loc_id")
    private Integer whOutputStockLocId;

    @JsonProperty(value = "view_location_id")
    private Integer viewLocationId;

    @JsonProperty(value = "delivery_steps")
    private String deliverySteps;

    @JsonProperty(value = "wh_qc_stock_loc_id")
    private Integer whQcStockLocId;

    @JsonProperty(value = "wh_input_stock_loc_id")
    private Integer whInputStockLocId;

    @JsonProperty(value = "out_type_id")
    private Integer outTypeId;

    @JsonProperty(value = "return_type_id")
    private Integer returnTypeId;

    @JsonProperty(value = "create_date")
    private String createDate;

    public static Warehouse valueOf(Row row) {
        return builder()
                .id(row.getID())
                .name(String.valueOf(row.getFieldsOdoo().get("name")))
                .lotStockId((Integer) (row.getFieldsOdoo().get("lot_stock_id")))
                .active((Boolean) (row.getFieldsOdoo().get("active")))
                .build();
    }
}
