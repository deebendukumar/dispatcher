package com.dispatcher.partners.service;

import com.dispatcher.partners.entity.Partner;

import java.util.List;

public interface PartnerService<T extends Partner> {

    T findByPKey(String id);
    List<T> findByPhone(String phone);
    List<T> findByName(String name);
    List<T> findAll();
    T create(Partner partner);
    T update(String id, Partner partner);
    T delete(String id);
}
