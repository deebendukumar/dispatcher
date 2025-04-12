package com.dispatcher.pim.service;

import com.dispatcher.pim.entity.Warehouse;

import java.util.List;

public interface WarehouseService<T extends Warehouse> {

    T findByPKey(String id);
    List<T> findAll();
    T create(Warehouse warehouse);
    T update(String id, Warehouse warehouse);
    T delete(String id);
}
