package com.spirngauth.authentication_spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spirngauth.authentication_spring.interfaces.IAttributes;
import com.spirngauth.authentication_spring.models.Attributes;
import com.spirngauth.authentication_spring.repository.AttributeRepo;

@Service
public class SAttributes implements IAttributes{
    @Autowired
    private AttributeRepo attributeRepo;


    public List<Attributes> findAllAttribute(){
        return attributeRepo.findAll();
    }
}
