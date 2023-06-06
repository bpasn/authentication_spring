package com.spirngauth.authentication_spring.services;

import com.spirngauth.authentication_spring.interfaces.IProduct;
import com.spirngauth.authentication_spring.payload.response.BaseResponse;
import com.spirngauth.authentication_spring.payload.response.ProductResponse;
import com.spirngauth.authentication_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("sProduct")
public class SProduct implements IProduct {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<String> getAllProduct() {
        return null;
    }

    @Override
    public Optional<String> getProductByname(String name) {
        return Optional.empty();
    }

    @Override
    public BaseResponse response(boolean flag){
        BaseResponse response = new BaseResponse();
        response.setSuccess(flag);
        if(flag){
            response.setMessage("Create Product Successfully!");
        }else{
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
   
}
