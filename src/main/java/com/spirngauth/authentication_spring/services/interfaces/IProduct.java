package com.spirngauth.authentication_spring.services.interfaces;


import com.spirngauth.authentication_spring.payload.request.product.RequestProduct;
import com.spirngauth.authentication_spring.payload.response.ResPayload;

import java.util.Optional;

public interface IProduct {
    ResPayload getAllProduct();
    Optional<String> getProductByname(String name);
    ResPayload loadingPage();
    ResPayload createProduct(RequestProduct req);
    
    // Map<String,Object> response();


}
