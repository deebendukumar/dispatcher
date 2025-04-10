package com.dispatcher.partners.repository;

import com.dispatcher.partners.data.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "partners", path = "partners")
@Repository
public interface PartnerRepository extends MongoRepository<Partner, String> {
}
