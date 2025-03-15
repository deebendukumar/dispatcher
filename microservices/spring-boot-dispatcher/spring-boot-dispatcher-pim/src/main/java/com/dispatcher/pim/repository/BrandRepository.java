package com.dispatcher.pim.repository;

import com.dispatcher.pim.entity.Brand;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "brands", path = "brands")
public interface BrandRepository extends PagingAndSortingRepository<Brand, String> {

    List<Brand> findByName(@Param("name") String name);
}
