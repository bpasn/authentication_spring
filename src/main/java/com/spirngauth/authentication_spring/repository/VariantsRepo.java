package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.Variants;

public interface VariantsRepo extends JpaRepository<Variants,Long>{
    
}
