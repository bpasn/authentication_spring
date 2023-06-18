package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.AttributeValues;
import com.spirngauth.authentication_spring.models.Attributes;

import java.util.List;
import java.util.Optional;


public interface AttributeValueRepo extends JpaRepository<AttributeValues,Long>{
    List<AttributeValues> findAllByAttributeId( Long attributeId);
    AttributeValues findAllByAttributeIdAndAttributeValue( Long attributeId,String attributeValueName);
}
