package com.dispatcher.service.odoo.mapper;

import com.dispatcher.service.model.Warehouse;
import com.dispatcher.service.odoo.model.OdooWarehouseObject;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { WarehouseJsonMapper.class })
public interface WarehouseJsonMapper {

    WarehouseJsonMapper INSTANCE = Mappers.getMapper(WarehouseJsonMapper.class);

//    @Mapping(target = "__last_update", ignore = true)
//    @Mapping(target = "resupply_route_ids", ignore = true)
//    @Mapping(target = "resupply_wh_ids", ignore = true)
//    @Mapping(target = "route_ids", ignore = true)
//    @Mapping(target = "write_date", ignore = true)
    @Mapping(source = "lot_stock_id", target = "lotStockId")
    @Mapping(source = "wh_pack_stock_loc_id", target = "whPackStockLocId")
    @Mapping(source = "crossdock_route_id", target = "crossdockRouteId")
    @Mapping(source = "delivery_route_id", target = "deliveryRouteId")
    @Mapping(source = "pack_type_id", target = "packTypeId")
    @Mapping(source = "partner_id", target = "partnerId")
    @Mapping(source = "in_type_id", target = "inTypeId")
    @Mapping(source = "create_date", target = "createDate")
    @Mapping(source = "pick_type_id", target = "pickTypeId")
    @Mapping(source = "reception_steps", target = "receptionSteps")
    @Mapping(source = "company_id", target = "companyId")
    @Mapping(source = "reception_route_id", target = "receptionRouteId")
    @Mapping(source = "wh_output_stock_loc_id", target = "whOutputStockLocId")
    @Mapping(source = "display_name", target = "displayName")
    @Mapping(source = "view_location_id", target = "viewLocationId")
    @Mapping(source = "delivery_steps", target = "deliverySteps")
    @Mapping(source = "wh_qc_stock_loc_id", target = "whQcStockLocId")
    @Mapping(source = "wh_input_stock_loc_id", target = "whInputStockLocId")
    @Mapping(source = "out_type_id", target = "outTypeId")
    @Mapping(source = "return_type_id", target = "returnTypeId")
    Warehouse toWarehouse(OdooWarehouseObject.FieldsOdoo fieldsOdoo);
}
