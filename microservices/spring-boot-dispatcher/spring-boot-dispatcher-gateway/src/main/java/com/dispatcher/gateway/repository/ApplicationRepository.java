package com.dispatcher.gateway.repository;

import com.dispatcher.gateway.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends MongoRepository<Application, Long> {

    Boolean existsByName(String name);
}
