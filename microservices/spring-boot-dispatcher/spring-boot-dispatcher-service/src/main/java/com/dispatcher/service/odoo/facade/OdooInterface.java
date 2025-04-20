package com.dispatcher.service.odoo.facade;

import com.dispatcher.service.base.entity.Auditable;
import com.dispatcher.service.entity.Country;
import com.dispatcher.service.odoo.api.Row;

import java.util.List;

public interface OdooInterface<T extends Auditable> {

    T findByPKey(Integer id);
    List<T> find();
    T create(T param);
    T update(Integer id, T param);
    void delete(Integer id);
}
