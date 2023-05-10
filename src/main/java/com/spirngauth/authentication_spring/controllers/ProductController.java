package com.spirngauth.authentication_spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spirngauth.authentication_spring.models.ECode;
import com.spirngauth.authentication_spring.payload.request.product.ProductRequest;
import com.spirngauth.authentication_spring.payload.response.MessageResponse;

import jakarta.validation.Valid;

// @CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    @GetMapping(path = "")
    public @ResponseBody String allAccept() {
        return "Product Controller";
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest request) throws Exception{
        
        try {
            
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new MessageResponse(e.getMessage(), ECode.ERROR));
        }
        return ResponseEntity.status(200).body(new MessageResponse(
            "Create Product Successfully",
            ECode.SUCCESS
        ));
    }

}
