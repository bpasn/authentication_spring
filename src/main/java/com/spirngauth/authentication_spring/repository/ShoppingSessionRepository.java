package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.ShoppingSession;

public interface ShoppingSessionRepository extends MongoRepository<ShoppingSession,String> {
    
}
