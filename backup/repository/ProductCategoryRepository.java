package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.ProductCategory;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory,String>{
    
}
