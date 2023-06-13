package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.Attributes;
import java.util.Optional;


public interface AttributeRepo extends JpaRepository<Attributes,Long>{
    Optional<Attributes> findByAttributeName(String attributeName);
}
