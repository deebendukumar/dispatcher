package com.dispatcher.gateway.repository;

import com.dispatcher.gateway.document.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends MongoRepository<Plan, Long> {

    Boolean existsByName(String name);
}
