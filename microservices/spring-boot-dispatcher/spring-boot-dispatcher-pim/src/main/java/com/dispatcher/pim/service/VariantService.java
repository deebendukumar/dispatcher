package com.dispatcher.pim.service;

import com.dispatcher.pim.entity.Variant;
import com.dispatcher.pim.entity.Warehouse;

import java.util.List;

public interface VariantService<T extends Variant> {

    T findByPKey(String id);
    List<T> findAll();
    T create(Variant variant);
    T update(String id, Variant variant);
    T delete(String id);
}
