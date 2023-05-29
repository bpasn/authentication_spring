package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.ProductSize;

public interface ProductSizeRepo extends MongoRepository<ProductSize,String>{
    
}
