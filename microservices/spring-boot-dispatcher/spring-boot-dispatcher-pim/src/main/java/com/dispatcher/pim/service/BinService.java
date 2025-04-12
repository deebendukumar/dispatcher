package com.dispatcher.pim.service;

import com.dispatcher.pim.entity.Bin;
import com.dispatcher.pim.entity.Warehouse;

import java.util.List;

public interface BinService<T extends Bin> {

    T findByPKey(String id);
    List<T> findAll();
    T create(Bin bin);
    T update(String id, Bin bin);
    T delete(String id);
}
