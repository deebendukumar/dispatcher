package com.dispatcher.partners.repository;

import com.dispatcher.service.model.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "partners", path = "partners")
@Repository
public interface PartnerRepository extends MongoRepository<Partner, String> {

}
