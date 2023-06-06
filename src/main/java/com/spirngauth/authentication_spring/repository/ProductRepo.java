package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.Products;

public interface ProductRepo extends JpaRepository<Products,Long> {
    
}
