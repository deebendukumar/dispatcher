package com.dispatcher.partners.repository;

import com.dispatcher.partners.entity.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "partners", path = "partners")
@Repository
public interface PartnerRepository extends MongoRepository<Partner, String> {
    List<Partner> findByPhone(String phone);

    List<Partner> findByName(String name);
}
