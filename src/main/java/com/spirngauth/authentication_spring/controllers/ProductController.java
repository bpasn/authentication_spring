package com.spirngauth.authentication_spring.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spirngauth.authentication_spring.models.Discount;
import com.spirngauth.authentication_spring.models.ECode;
import com.spirngauth.authentication_spring.models.Product;
import com.spirngauth.authentication_spring.models.ProductCategory;
import com.spirngauth.authentication_spring.models.ProductInventory;
import com.spirngauth.authentication_spring.payload.request.product.ProductRequest;
import com.spirngauth.authentication_spring.payload.response.MessageResponse;
import com.spirngauth.authentication_spring.repository.DiscountRepository;
import com.spirngauth.authentication_spring.repository.ProductCategoryRepository;
import com.spirngauth.authentication_spring.repository.ProductInventoryRepository;
import com.spirngauth.authentication_spring.repository.ProductRepository;

import jakarta.validation.Valid;

// @CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductInventoryRepository productInventoryRepository;

    @Autowired
    private DiscountRepository discountRepository;

    @GetMapping(path = "")
    public @ResponseBody String allAccept() {
        return "Product Controller";
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest productRequest) throws Exception {

        try {
            Product product = new Product(productRequest.getName(), productRequest.getDesc(), productRequest.getSKU(),
                    productRequest.getPrice());
            List<ProductCategory> getCategory = productRequest.getCategory();
            List<ProductInventory> getInventory = productRequest.getInventory();
            List<Discount> getDiscountPercent = productRequest.getDiscountPercent();

            getCategory.forEach(category -> product.setCategory(category));
            getInventory.forEach(inventory -> product.setInventory(inventory));
            getDiscountPercent.forEach(dicsount -> product.setDiscount((dicsount)));

            productCategoryRepository.save(product.getCategory());
            productInventoryRepository.save(product.getInventory());
            discountRepository.save(product.getDiscount());
            productRepository.save(product);

            return ResponseEntity.ok(new MessageResponse("Create Product Successfully !",ECode.SUCCESS));
        } catch (Exception e) {
            logger.error("ERROR [FUNCTION CREATEPRODUCT] : {}", e.getMessage());
            return ResponseEntity.status(500).body(new MessageResponse(e.getMessage()));

        }

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Product>> getAllProduct(){
        
        List<Product> product = productRepository.findAll();
        return new ResponseEntity<List<Product>>(product, null, 200);
    }
}
