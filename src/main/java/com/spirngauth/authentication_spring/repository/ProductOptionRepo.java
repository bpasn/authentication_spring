package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.ProductOption;

public interface ProductOptionRepo extends MongoRepository<ProductOption,String>{
    
}
