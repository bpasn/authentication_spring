package com.spirngauth.authentication_spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.Product;

public interface ProductRepository extends MongoRepository<Product,String> {
    
    Optional<Product> findById(String id);
    Optional<Product> findByName(String name);
}
