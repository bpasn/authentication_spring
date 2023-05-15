package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.OrderItem;

public interface OrderItemRepository extends MongoRepository<OrderItem,String>{
    
}
