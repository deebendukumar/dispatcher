package com.dispatcher.pim.entity;

import com.dispatcher.service.integration.ApplicationEntity;

import java.io.Serializable;

public class Variant extends ApplicationEntity implements Serializable {

    //product_id
    //title
    //body
    //body_html
    //short_description
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

    //depth
    //height
    //width
    //volume
    //grams
    //weight
    //weight_unit
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
