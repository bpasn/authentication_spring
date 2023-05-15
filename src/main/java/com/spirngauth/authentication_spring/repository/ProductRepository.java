package com.spirngauth.authentication_spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.Product;

public interface ProductRepository extends MongoRepository<Product,String> {

    // @Query(fields = "{id:1,name:1desc:1, SKU:1,category:1,inventory:1,price:1,discount:1}")
    Optional<Product> findById(String id);
    Optional<Product> findByName(String name);
}
