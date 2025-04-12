package com.dispatcher.pim.service;

import com.dispatcher.pim.entity.Product;
import com.dispatcher.pim.entity.Warehouse;

import java.util.List;

public interface ProductService<T extends Product> {

    T findByPKey(String id);
    List<T> findAll();
    T create(Product product);
    T update(String id, Product product);
    T delete(String id);
}
