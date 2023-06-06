package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.ProductAttributes;

public interface ProductAttributeRepo extends JpaRepository<ProductAttributes,Long> {
    
}
