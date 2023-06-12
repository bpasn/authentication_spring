package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spirngauth.authentication_spring.models.AttributeValues;
import com.spirngauth.authentication_spring.models.Attributes;

import java.util.List;
import java.util.Optional;


public interface AttributeValueRepo extends JpaRepository<AttributeValues,Long>{
    // @Query("""
    //         SELECT * from attribute_value where :attribute_id 
    //         """)
    List<AttributeValues> findAllByAttributeId( Attributes attributeId);
    AttributeValues findByAttributeId(Attributes attributesId);
    // @Query("SELECT * FROM attribute_value where attribute_name = ?1 and attribute_id = ?1")
    Optional<AttributeValues> findByAttributeValueAndAttributeId(String attributeValue,Attributes attributes);
}