package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.VariantAttributeValues;

public interface VariantAttributeValuesRepo extends JpaRepository<VariantAttributeValues,Long>{
    
}
