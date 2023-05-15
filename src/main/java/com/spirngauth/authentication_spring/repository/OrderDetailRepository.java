package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.OrderDetails;

public interface OrderDetailRepository extends  MongoRepository<OrderDetails,String>{
    
}
