package com.dispatcher.pim.repository;

import com.dispatcher.pim.entity.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "partners", path = "partners")
@Repository
public interface BrandRepository extends MongoRepository<Brand, String> {

    List<Brand> findByName(@Param("name") String name);
}
