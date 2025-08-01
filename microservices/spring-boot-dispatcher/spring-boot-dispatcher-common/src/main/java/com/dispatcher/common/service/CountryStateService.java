package com.dispatcher.common.service;

import com.dispatcher.service.model.State;

import java.util.List;

public interface CountryStateService<T extends State> {

    T findByPKey(String id);
    List<T> findAll();
}
