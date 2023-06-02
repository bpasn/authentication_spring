package com.spirngauth.authentication_spring.controllers;

import com.spirngauth.authentication_spring.services.SProduct;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/product")
@SecurityRequirement(name = "bearerAuth")
public class ProductController {
    @Autowired
    private SProduct sProduct;


    @GetMapping("")
    public ResponseEntity<List<String>> getProduct(){
        return ResponseEntity.ok(sProduct.getAllProduct());
    }


}
