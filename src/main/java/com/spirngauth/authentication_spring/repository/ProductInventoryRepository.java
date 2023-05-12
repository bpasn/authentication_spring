package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.ProductInventory;

public interface ProductInventoryRepository extends MongoRepository<ProductInventory, String> {

}
