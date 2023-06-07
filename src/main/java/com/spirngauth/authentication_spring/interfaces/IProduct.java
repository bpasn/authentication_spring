package com.spirngauth.authentication_spring.interfaces;


import com.spirngauth.authentication_spring.models.Products;
import com.spirngauth.authentication_spring.payload.request.product.RequestProduct;
import com.spirngauth.authentication_spring.payload.response.BaseResponse;
import com.spirngauth.authentication_spring.payload.response.ProductResponse;
import com.spirngauth.authentication_spring.payload.response.ResPayload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProduct {
    List<Products> getAllProduct();
    Optional<String> getProductByname(String name);
    ResPayload loadingPage();
    ResPayload createProduct(RequestProduct req);
    
    // Map<String,Object> response();


}
