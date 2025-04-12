package com.dispatcher.pim.repository;

import com.dispatcher.pim.entity.Brand;
import com.dispatcher.pim.entity.Hazmat;
import com.dispatcher.pim.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "partners", path = "partners")
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Brand> findByName(@Param("name") String name);
}
