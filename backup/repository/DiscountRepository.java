package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.Discount;

public interface DiscountRepository extends MongoRepository<Discount,String>{
    
}
