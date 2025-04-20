package com.dispatcher.common.service;

import com.dispatcher.service.entity.Country;

import java.util.List;

public interface CountryService<T extends Country> {

    T findByPKey(Integer id);
    List<T> findAll();
}
