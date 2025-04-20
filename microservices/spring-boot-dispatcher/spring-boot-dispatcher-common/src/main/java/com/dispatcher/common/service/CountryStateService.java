package com.dispatcher.common.service;

import com.dispatcher.service.entity.Country;
import com.dispatcher.service.entity.State;

import java.util.List;

public interface CountryStateService<T extends State> {

    T findByPKey(String id);
    List<T> findAll();
}
