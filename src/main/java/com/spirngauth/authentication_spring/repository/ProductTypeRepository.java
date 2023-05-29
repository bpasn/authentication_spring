package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.ProductType;

public interface ProductTypeRepository extends MongoRepository<ProductType,String>{
    
}
