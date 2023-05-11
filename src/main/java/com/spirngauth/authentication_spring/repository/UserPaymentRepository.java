package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.UserPayment;

public interface UserPaymentRepository extends MongoRepository<UserPayment,String> {
    
}
