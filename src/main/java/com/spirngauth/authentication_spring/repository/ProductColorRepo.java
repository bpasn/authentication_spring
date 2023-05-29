package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.ProductColor;

public interface ProductColorRepo extends MongoRepository<ProductColor,String>{
    
}
