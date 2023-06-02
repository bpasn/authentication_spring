package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserPaymentRepository extends MongoRepository<UserPayment,String> {
    
}
