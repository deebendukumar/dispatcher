package com.dispatcher.inventory.entity;

import com.dispatcher.service.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@JsonPropertyOrder({
        "id"
})
@Data
@Builder
@Document(collection = "stock_record")
public class StockRecord extends BaseEntity {

    @Field(name = "variant_id")
    @JsonProperty(value = "variant_id")
    private String variantId;

    @Field(name = "activity_code")
    @JsonProperty(value = "activity_code")
    private String activityCode;

//    @Field(name = "activity_code")
//    @JsonProperty(value = "activity_code")
//    private String activityCode;

    //barcode - A UPC for the product
    //product_group
    //product_type
    //purchase_qty_uom -receiving unit of measure
    //purchase_uom_conversion_factor
    //purchase_pack_qty purchase standard pack quantity
    //stock_qty_uom inventory unit of measure
    //stock_uon_conversion_factor
    //shipping_qty_uom
    //shipping_uom_conversion_factor
    //total_qty_on_hand
    //min_purchase_quantity
    //min_reorder_quantity
    //min_on_hand_qty
    //max_on_hand_qty
    //min_order_qty
    //max_order_qty
    //units_per_case
    //cases_per_pallet
    //base_cost
    //supplier_cost
    //fulfillment_service

    //dimensions
    //packed_dimensions

    //inventory_item_id
    //inventory_management
    //inventory_policy
    //inventory_quantity

    //price
    //requires_shipping
    //sku
    //tags
    //batch_no_flag this flag indicates if the product required lot tracking
    //bin_loc_flag  this flag indicates if the product is stored in bin location
    //fifo
    //active

    //standard_cost
    //standard_currency
    //vat_code
    //gst_code
    //ean

    //fragile
    //hazmat - Whether a hazardous material or not
    //hazmat_id
    //max_stack maximum stack size
    //obsolete_product disable further receiving of the product

    //packed_depth
    //packed_height
    //packed_volume
    //packed_weight
    //packed_width

    //user_def_1
    //user_def_2
    //user_def_3
    //user_def_4
    //user_def_5
    //user_def_6
    //user_def_7
    //user_def_8
}
