package com.dispatcher.common.service;

import com.dispatcher.service.entity.Currency;

import java.util.List;

public interface CurrencyService<T extends Currency> {

    T findByPKey(Integer id);
    List<T> findAll();
}
