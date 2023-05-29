package com.spirngauth.authentication_spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.Product;

public interface ProductRepository extends MongoRepository<Product,String> {

   
    Optional<Product> findById(String id);
    Optional<Product> findByName(String name);
}
