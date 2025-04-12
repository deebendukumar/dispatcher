package com.dispatcher.pim.service;

import com.dispatcher.pim.entity.Rack;
import com.dispatcher.pim.entity.Warehouse;

import java.util.List;

public interface RackService<T extends Rack> {

    T findByPKey(String id);
    List<T> findAll();
    T create(Rack rack);
    T update(String id, Rack rack);
    T delete(String id);
}
