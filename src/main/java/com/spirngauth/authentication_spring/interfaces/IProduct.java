package com.spirngauth.authentication_spring.interfaces;


import com.spirngauth.authentication_spring.payload.response.BaseResponse;
import com.spirngauth.authentication_spring.payload.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface IProduct {
    List<String> getAllProduct();
    Optional<String> getProductByname(String name);
    BaseResponse response(boolean flag);
    ProductResponse productResponse();


}
