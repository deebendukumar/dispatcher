package com.dispatcher.gateway.service.impl;

import com.dispatcher.gateway.document.Plan;
import com.dispatcher.gateway.repository.PlanRepository;
import com.dispatcher.gateway.service.PlanService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

    private PlanRepository repository;

    public PlanServiceImpl(PlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Plan findById(Long id) {
        Optional<Plan> optional = this.repository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public List<Plan> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Plan create(Plan plan) {
        plan.setId(String.valueOf(plan.generateRandomNumber()));
        if (repository.existsByName(plan.getName()))
            throw new DuplicateKeyException("name already exist");
        return repository.save(plan);
    }

    @Override
    public Boolean delete(Long id) {
        Boolean status = false;
        if (repository.existsById(id)) {
            repository.delete(repository.findById(id).get());
            status = true;
        }
        return status;
    }
}
