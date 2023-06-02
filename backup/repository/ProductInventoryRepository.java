package com.spirngauth.authentication_spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductInventoryRepository extends MongoRepository<ProductInventory, String> {

}
