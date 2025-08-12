package com.dispatcher.service.service;

import com.dispatcher.service.model.Currency;

import java.util.List;

public interface CurrencyService<T extends Currency> {

    T findByPKey(Integer id);
    List<T> findAll();
}
