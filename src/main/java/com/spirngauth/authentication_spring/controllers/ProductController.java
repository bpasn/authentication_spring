package com.spirngauth.authentication_spring.controllers;

import com.spirngauth.authentication_spring.models.Products;
import com.spirngauth.authentication_spring.payload.request.product.RequestProduct;
import com.spirngauth.authentication_spring.payload.response.BaseResponse;
import com.spirngauth.authentication_spring.payload.response.ResPayload;
import com.spirngauth.authentication_spring.services.SProduct;

import io.swagger.models.Response;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private SProduct sProduct;

    @GetMapping("loading-page")
    public ResponseEntity<ResPayload> loadingPage() {
        return ResponseEntity.ok(sProduct.loadingPage());
    }

    @PostMapping(value = "/post", consumes = "application/json")
    public ResponseEntity<ResPayload> postProduct(@RequestBody RequestProduct product) {
        return ResponseEntity.ok(sProduct.createProduct(product));
    }

    @GetMapping("get")
    public ResponseEntity<HashMap<String, String>> get() {
        HashMap<String, String> res = new HashMap<>();
        res.put("status", "9999");
        res.put("payload", "PRODUCT IS NULL");
        return ResponseEntity.ok(res);
    }

}
