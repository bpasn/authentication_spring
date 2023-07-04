package com.spirngauth.authentication_spring.interfaces;


import com.spirngauth.authentication_spring.models.Products;
import com.spirngauth.authentication_spring.payload.request.product.RequestProduct;
import com.spirngauth.authentication_spring.payload.response.ResPayload;

import java.util.List;
import java.util.Optional;

public interface IProduct {
    ResPayload getAllProduct(int page, int pageSize);
    Optional<String> getProductByname(String name);
    ResPayload loadingPage();
    ResPayload createProduct(RequestProduct req);
    String generateSKU(Products sku);
    
    // Map<String,Object> response();


}
