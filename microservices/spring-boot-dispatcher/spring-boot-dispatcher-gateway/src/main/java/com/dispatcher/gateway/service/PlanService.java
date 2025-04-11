package com.dispatcher.gateway.service;

import com.dispatcher.gateway.document.Plan;

import java.util.List;

public interface PlanService {

    Plan findById(Long id);
    List<Plan> findAll();
    Plan create(Plan plan);
    Boolean delete(Long id);
}
