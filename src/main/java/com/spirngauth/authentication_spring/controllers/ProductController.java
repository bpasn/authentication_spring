package com.spirngauth.authentication_spring.controllers;

import com.spirngauth.authentication_spring.payload.request.product.RequestProduct;
import com.spirngauth.authentication_spring.payload.response.ResPayload;
import com.spirngauth.authentication_spring.services.SProduct;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/product")
@SecurityRequirement(name = "bearerAuth")
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SProduct sProduct;

    @GetMapping("loading-page")
    public ResponseEntity<ResPayload> loadingPage() {
        return ResponseEntity.ok(sProduct.loadingPage());
    }

    @PostMapping(value = "/post")
    public ResponseEntity<ResPayload> postProduct(@Valid @RequestBody RequestProduct product) {
        logger.info(product.toString());
        return ResponseEntity.ok(sProduct.createProduct(product));
    }

    @GetMapping("get")
    public ResponseEntity<ResPayload> getProduct() {
        return ResponseEntity.ok(sProduct.getAllProduct());
    }

}
