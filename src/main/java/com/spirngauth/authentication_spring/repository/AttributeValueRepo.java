package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.AttributeValues;
import com.spirngauth.authentication_spring.models.Attributes;

import java.util.List;


public interface AttributeValueRepo extends JpaRepository<AttributeValues,Long>{
    List<AttributeValues> findByAttributeId(Attributes attributeId);
}
