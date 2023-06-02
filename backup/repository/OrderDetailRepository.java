package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderDetailRepository extends  MongoRepository<OrderDetails,String>{
    
}
