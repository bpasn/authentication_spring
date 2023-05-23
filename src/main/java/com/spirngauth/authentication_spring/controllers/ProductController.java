package com.spirngauth.authentication_spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spirngauth.authentication_spring.models.Discount;
import com.spirngauth.authentication_spring.models.Product;
import com.spirngauth.authentication_spring.models.ProductCategory;
import com.spirngauth.authentication_spring.models.ProductImage;
import com.spirngauth.authentication_spring.models.ProductInventory;
import com.spirngauth.authentication_spring.payload.request.TestRequest;
import com.spirngauth.authentication_spring.payload.request.product.ProductRequest;
import com.spirngauth.authentication_spring.payload.response.MessageResponse;
import com.spirngauth.authentication_spring.payload.response.ResponseMessage;
import com.spirngauth.authentication_spring.repository.DiscountRepository;
import com.spirngauth.authentication_spring.repository.ProductCategoryRepository;
import com.spirngauth.authentication_spring.repository.ProductImageRepository;
import com.spirngauth.authentication_spring.repository.ProductInventoryRepository;
import com.spirngauth.authentication_spring.repository.ProductRepository;
import com.spirngauth.authentication_spring.services.CreateImagesService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/product")
@SecurityRequirement(name = "bearerAuth")

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

    @Autowired
    private CreateImagesService createImagesService;

    @Autowired
    ProductImageRepository productImageRepository;

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

            return ResponseEntity.ok(new MessageResponse("Create Product Successfully !", HttpStatus.CREATED));
        } catch (Exception e) {
            logger.error("ERROR [FUNCTION CREATEPRODUCT] : {}", e.getMessage());
            throw new Exception("ERROR " + e.getMessage());

        }

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> product = productRepository.findAll();
        return new ResponseEntity<List<Product>>(product, null, 200);
    }

    @PostMapping(path = "/test", consumes = "multipart/form-data", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> testRequest(@ModelAttribute TestRequest request) {
        try {
            List<String> paths = createImagesService.createImage(request.getFiles());
            ProductImage productImage = new ProductImage();
            productImage.setAttibuteSet(request.getAttributeSet());
            productImage.setProductType(request.getProductType());
            productImage.setImages(paths);
            String id = productImageRepository.save(productImage).getId();

            Map<String, String> map = new HashMap<>();
            map.put("id", id);
            map.put("message", "Upload Images Successfully!");

            
            return ResponseEntity.ok(new ResponseMessage(true, map));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
