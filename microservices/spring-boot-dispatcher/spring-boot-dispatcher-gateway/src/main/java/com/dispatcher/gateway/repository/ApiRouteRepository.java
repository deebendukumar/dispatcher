package com.dispatcher.gateway.repository;

import com.dispatcher.gateway.document.ApiRoute;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRouteRepository extends MongoRepository<ApiRoute, String> {

    Boolean existsByContext(String path);
}
