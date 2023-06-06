package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.Attributes;

public interface AttributeRepo extends JpaRepository<Attributes,Long>{
    
}
