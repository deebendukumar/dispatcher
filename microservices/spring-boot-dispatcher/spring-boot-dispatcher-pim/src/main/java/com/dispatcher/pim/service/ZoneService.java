package com.dispatcher.pim.service;

import com.dispatcher.pim.entity.Warehouse;
import com.dispatcher.pim.entity.Zone;

import java.util.List;

public interface ZoneService<T extends Zone> {

    T findByPKey(String id);
    List<T> findAll();
    T create(Zone zone);
    T update(String id, Zone zone);
    T delete(String id);
}
