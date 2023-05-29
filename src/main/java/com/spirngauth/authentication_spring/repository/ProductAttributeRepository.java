package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.ProductAttribute;

public interface ProductAttributeRepository extends MongoRepository<ProductAttribute,String>{
    
}
