package com.dispatcher.service.odoo.model;

import com.dispatcher.common.base.Auditable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OdooWarehouseObject implements Auditable {

    private int id;

    @JsonProperty("fieldsOdoo")
    private FieldsOdoo fieldsOdoo;

    @Data
    public static class FieldsOdoo implements Auditable {

        public int lot_stock_id;
        private int wh_pack_stock_loc_id;
        private int write_uid;
        private String code;
        private int crossdock_route_id;
        private int delivery_route_id;
        private int pack_type_id;
        private int partner_id;
        private int mto_pull_id;
        private int id;
        private int in_type_id;
        private String create_date;
        private int pick_type_id;
        private String reception_steps;
        private int company_id;
        private int int_type_id;
        private boolean active;
        private int reception_route_id;
        private int wh_output_stock_loc_id;
        private String display_name;
        private int create_uid;
        private int view_location_id;
        private String delivery_steps;
        private int wh_qc_stock_loc_id;
        private int sequence;
        private String name;
        private int wh_input_stock_loc_id;
        private int out_type_id;
        private int return_type_id;
    }
}