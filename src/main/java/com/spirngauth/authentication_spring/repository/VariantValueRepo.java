package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.VariantValues;

public interface VariantValueRepo extends JpaRepository<VariantValues,Long>{
    
}
