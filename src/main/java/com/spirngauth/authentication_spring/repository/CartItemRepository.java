package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.CartItem;

public interface CartItemRepository extends MongoRepository<CartItem,String>{
    
}
