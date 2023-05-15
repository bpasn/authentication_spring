package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.UserAddress;

public interface UserAddressRepository extends MongoRepository<UserAddress,String> {
    
}
