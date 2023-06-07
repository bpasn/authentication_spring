package com.spirngauth.authentication_spring.services;

import com.spirngauth.authentication_spring.interfaces.IProduct;
import com.spirngauth.authentication_spring.models.AttributeValues;
import com.spirngauth.authentication_spring.models.Attributes;
import com.spirngauth.authentication_spring.models.Products;
import com.spirngauth.authentication_spring.payload.response.BaseResponse;
import com.spirngauth.authentication_spring.payload.response.ProductResponse;
import com.spirngauth.authentication_spring.repository.AttributeRepo;
import com.spirngauth.authentication_spring.repository.AttributeValueRepo;
import com.spirngauth.authentication_spring.repository.ProductRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("sProduct")
public class SProduct implements IProduct {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeValueRepo attributeValueRepo;

    private static Logger logger = LoggerFactory.getLogger(SProduct.class);

    public static final String message = "Product Controller";
    @Override
    public List<Products> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Optional<String> getProductByname(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductByname'");
    }

    @Override
    public List<Map<String, Object>>loadingPage() {

        List<Map<String, Object>> payload = new ArrayList<>();

        List<Attributes> attributes = attributeRepo.findAll();

        attributes.forEach((Attributes attr) -> {
            Map<String, Object> mapOb = new HashMap<>();
            List<AttributeValues> attVal = attributeValueRepo.findByAttributeId(attr);
            List<HashMap<String, String>> map = new ArrayList<>();
            attVal.forEach((AttributeValues val) -> {
                HashMap<String, String> valueMap = new HashMap<>();
                valueMap.put("name", val.getAttributeValue());
                valueMap.put("id", val.getId().toString());
                map.add(valueMap);
            });
            mapOb.put("name",attr.getAttributeName());
            mapOb.put("id",attr.getId().toString());
            mapOb.put("options", map);
            payload.add(mapOb);
        });

        return payload;
    }

    public ProductResponse response (Boolean flg)
    {
        ProductResponse res = new ProductResponse();
        if(flg){
            res.setSuccess(flg);
            res.setMessage(message);
        }else{
            res.setSuccess(flg);
            res.setMessage("FAILED "+message);
        }
        return res;
    }
    public ProductResponse response (Boolean flg, String msg)
    {
        msg = this.message;
        ProductResponse res = new ProductResponse();
        res.setSuccess(flg);
        res.setMessage(msg);
        return res;
    }


    
}
