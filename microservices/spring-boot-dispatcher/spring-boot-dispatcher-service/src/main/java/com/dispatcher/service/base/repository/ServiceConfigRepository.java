package com.dispatcher.service.base.repository;

import com.dispatcher.service.base.entity.SequenceNumber;
import com.dispatcher.service.base.entity.ServiceConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "partners", path = "partners")
@Repository
public interface ServiceConfigRepository extends MongoRepository<ServiceConfig, String> {
}
