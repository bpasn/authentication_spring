package com.spirngauth.authentication_spring.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spirngauth.authentication_spring.models.ProductCategory;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {

}
