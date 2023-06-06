package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.AttributeValues;

public interface AttributeValueRepo extends JpaRepository<AttributeValues,Long>{
    
}
