package com.spirngauth.authentication_spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spirngauth.authentication_spring.models.ProductCategory;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {

    @Query(value="{ 'name' : ?0 }", fields="{ 'name' : 1, '_id' : 1,'created_at' : 1, 'modified_at': 1, 'deleted_at': 1 }")
    List<ProductCategory> findByProductCategory();
}
