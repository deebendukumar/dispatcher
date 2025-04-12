package com.dispatcher.pim.repository;

import com.dispatcher.pim.entity.Bin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "partners", path = "partners")
@Repository
public interface BinRepository extends MongoRepository<Bin, String> {
}
