package com.spirngauth.authentication_spring.services;

import com.spirngauth.authentication_spring.interfaces.IProduct;
import com.spirngauth.authentication_spring.models.AttributeValues;
import com.spirngauth.authentication_spring.models.Attributes;
import com.spirngauth.authentication_spring.models.Categories;
import com.spirngauth.authentication_spring.models.Products;
import com.spirngauth.authentication_spring.payload.response.BaseResponse;
import com.spirngauth.authentication_spring.payload.response.ProductResponse;
import com.spirngauth.authentication_spring.repository.AttributeRepo;
import com.spirngauth.authentication_spring.repository.AttributeValueRepo;
import com.spirngauth.authentication_spring.repository.CategoriesRepo;
import com.spirngauth.authentication_spring.repository.ProductRepo;
import com.spirngauth.authentication_spring.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service("sProduct")
public class SProduct implements IProduct {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoriesRepo categoriesRepo;

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeValueRepo attributeValueRepo;

    private static Logger logger = LoggerFactory.getLogger(SProduct.class);

    @Override
    public List<Products> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Products> getProductByname(String name) {
        return productRepo.findByProductName(name);
    }

    @Override
    public BaseResponse response(boolean flag) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(flag);
        if (flag) {
            response.setMessage("Create Product Successfully!");
        } else {
            response.setMessage("Create Product Failed!");
        }
        return response;
    }

    @Override
    public ProductResponse productResponse() {
        ProductResponse response = new ProductResponse();
        response.setPayload("PRODUCT IS NULL");
        return response;
    }

    @Override
    public  HashMap<String, List<HashMap<String, String>>> loadingPage() {

        HashMap<String, List<HashMap<String, String>>> payload = new HashMap<>();

        List<Attributes> attributes = attributeRepo.findAll();
        attributes.forEach((Attributes attr) -> {
            List<AttributeValues> attVal = attributeValueRepo.findByAttributes(attr);
            List<HashMap<String, String>> map = new ArrayList<>();
            attVal.forEach((AttributeValues val) -> {
                HashMap<String, String> valueMap = new HashMap<>();
                valueMap.put("name", val.getAttributeValue());
                valueMap.put("id", val.getId().toString());
                map.add(valueMap);
            });
            payload.put(attr.getAttributeName(), map);
        });

        return payload;
    }

}
