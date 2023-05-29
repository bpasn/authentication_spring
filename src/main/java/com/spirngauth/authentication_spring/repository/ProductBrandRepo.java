package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.ProductBrand;

public interface ProductBrandRepo extends MongoRepository<ProductBrand,String>{
    
}
