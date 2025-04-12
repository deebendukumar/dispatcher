package com.dispatcher.pim.service;

import com.dispatcher.pim.entity.Brand;
import com.dispatcher.pim.entity.Warehouse;

import java.util.List;

public interface BrandService<T extends Brand> {

    T findByPKey(String id);
    List<T> findAll();
    T create(Brand brand);
    T update(String id, Brand brand);
    T delete(String id);
}
