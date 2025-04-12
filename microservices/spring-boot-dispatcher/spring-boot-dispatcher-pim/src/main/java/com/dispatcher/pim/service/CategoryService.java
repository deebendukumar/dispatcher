package com.dispatcher.pim.service;

import com.dispatcher.pim.entity.Category;
import com.dispatcher.pim.entity.Warehouse;

import java.util.List;

public interface CategoryService<T extends Category> {

    T findByPKey(String id);
    List<T> findAll();
    T create(Category category);
    T update(String id, Category category);
    T delete(String id);
}
