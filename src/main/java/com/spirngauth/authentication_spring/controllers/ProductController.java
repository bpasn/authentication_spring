package com.spirngauth.authentication_spring.controllers;

import com.spirngauth.authentication_spring.payload.response.BaseResponse;
import com.spirngauth.authentication_spring.services.SProduct;

import io.swagger.models.Response;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/product")
@SecurityRequirement(name = "bearerAuth")
public class ProductController {
    @Autowired
    private SProduct sProduct;


     @GetMapping("")
     public ResponseEntity<?> getProduct(){
         return ResponseEntity.ok(sProduct.response(true));
     }

     @GetMapping("loading-page")
     public ResponseEntity<?> loadingPage(){
         return ResponseEntity.ok(sProduct.loadingPage());
     }


    @PostMapping(value = "/post", consumes ="application/json")
    public ResponseEntity<BaseResponse> postProduct(){
        return ResponseEntity.ok(sProduct.response(false));
    }

    @GetMapping("get")
    public ResponseEntity<HashMap<String,String>> get(){
        HashMap<String,String> res = new HashMap<>();
        res.put("status","9999"); 
        res.put("payload", "PRODUCT IS NULL");
        return ResponseEntity.ok(res);
    }



}
