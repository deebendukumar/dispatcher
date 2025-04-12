package com.dispatcher.pim.repository;

import com.dispatcher.pim.entity.Brand;
import com.dispatcher.pim.entity.Product;
import com.dispatcher.pim.entity.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "partners", path = "partners")
@Repository
public interface WarehouseRepository extends MongoRepository<Warehouse, String> {

    List<Brand> findByName(@Param("name") String name);
}
