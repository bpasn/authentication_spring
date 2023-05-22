package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.ProductImage;

public interface ProductImageRepository extends MongoRepository<ProductImage,String>{
}
