package com.spirngauth.authentication_spring.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spirngauth.authentication_spring.models.AttributeValues;
import com.spirngauth.authentication_spring.payload.response.ResPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spirngauth.authentication_spring.interfaces.IAttributes;
import com.spirngauth.authentication_spring.models.Attributes;
import com.spirngauth.authentication_spring.repository.AttributeRepo;

@Service
public class SAttributes implements IAttributes{
    @Autowired
    private AttributeRepo attributeRepo;


    public ResPayload findAllAttribute(){
        ResPayload response = new ResPayload();
        response.setSuccess(true);
        List<Map<String,Object>> sAttribute = new ArrayList<>();
        attributeRepo.findAll().forEach(item -> {
            Map<String,Object> mapOp = new HashMap<>();
            mapOp.put("name",item.getAttributeName());
            List<Map<String,String>> vAttribute = new ArrayList<>();
            item.getAttributeValues().forEach((AttributeValues v) -> {
                Map<String,String> mapV = new HashMap<>();
                mapV.put("name",v.getAttributeValue());
                mapV.put("id",v.getId().toString());
                vAttribute.add(mapV);
            });
            mapOp.put("options",vAttribute);
            mapOp.put("id",item.getId());
            sAttribute.add(mapOp);
        });

        response.setPayload(sAttribute);
        return response;
    }
}
