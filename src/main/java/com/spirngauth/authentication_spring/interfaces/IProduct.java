package com.spirngauth.authentication_spring.interfaces;


import com.spirngauth.authentication_spring.models.Products;
import com.spirngauth.authentication_spring.payload.response.BaseResponse;
import com.spirngauth.authentication_spring.payload.response.ProductResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProduct {
    List<Products> getAllProduct();
    Optional<String> getProductByname(String name);
    List<Map<String, Object>> loadingPage();


}
