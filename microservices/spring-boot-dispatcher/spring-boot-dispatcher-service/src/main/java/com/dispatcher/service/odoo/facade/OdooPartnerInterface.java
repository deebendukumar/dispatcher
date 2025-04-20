package com.dispatcher.service.odoo.facade;

import com.dispatcher.service.base.entity.Auditable;
import com.dispatcher.service.entity.Partner;

import java.util.List;
import java.util.Optional;

public interface OdooPartnerInterface<T extends Auditable> {

    T findByPKey(Integer id);
    List<T> find(Optional<String> name, Optional<String> phone, Optional<String> mobile);
    T create(T param);
    T update(Integer id, Partner param);
    void delete(Integer id);
}
