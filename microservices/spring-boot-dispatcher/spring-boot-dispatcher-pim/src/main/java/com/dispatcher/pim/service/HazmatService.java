package com.dispatcher.pim.service;

import com.dispatcher.pim.entity.Hazmat;
import com.dispatcher.pim.entity.Warehouse;

import java.util.List;

public interface HazmatService<T extends Hazmat> {

    T findByPKey(String id);
    List<T> findAll();
    T create(Hazmat hazmat);
    T update(String id, Hazmat hazmat);
    T delete(String id);
}
