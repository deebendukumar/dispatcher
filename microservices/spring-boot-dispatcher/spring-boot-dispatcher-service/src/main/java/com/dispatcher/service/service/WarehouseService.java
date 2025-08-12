package com.dispatcher.service.service;

import com.dispatcher.service.model.Warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface WarehouseService<T extends HashMap<String, Object>> {

    T findByPKey(Integer id);
    List<T> find(Optional<String> code);
    void create(Warehouse warehouse);
}
