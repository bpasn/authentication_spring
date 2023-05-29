package com.spirngauth.authentication_spring.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spirngauth.authentication_spring.models.ProductAttribute;
import com.spirngauth.authentication_spring.models.ProductBrand;
// import com.spirngauth.authentication_spring.models.ProductCategory;
import com.spirngauth.authentication_spring.models.ProductColor;
import com.spirngauth.authentication_spring.models.ProductSize;
import com.spirngauth.authentication_spring.models.ProductType;
import com.spirngauth.authentication_spring.repository.ProductAttributeRepository;
import com.spirngauth.authentication_spring.repository.ProductBrandRepo;
import com.spirngauth.authentication_spring.repository.ProductCategoryRepository;
import com.spirngauth.authentication_spring.repository.ProductColorRepo;
import com.spirngauth.authentication_spring.repository.ProductSizeRepo;
import com.spirngauth.authentication_spring.repository.ProductTypeRepository;

@Configuration
public class CommandlindRunner implements CommandLineRunner {
    private final String JSONFILE = "/data.json";

    @Autowired
    private ProductCategoryRepository productCategory;
    @Autowired
    private ProductSizeRepo productSizeRepo;
    @Autowired
    private ProductAttributeRepository productAttributeRepository;
    @Autowired
    private ProductBrandRepo productBrandRepo;
    @Autowired
    private ProductColorRepo productColorRepo;
    @Autowired
    private ProductTypeRepository productTypeRepository;



    @Override
    public void run(String... args) throws Exception {
        // TypeReference<HashMap<String, List<String>>> typeReference = new TypeReference<HashMap<String, List<String>>>() {
        // };

        // InputStream inputStream = TypeReference.class.getResourceAsStream(JSONFILE);

        // HashMap<String, List<String>> json = new ObjectMapper().readValue(inputStream, typeReference);
        // // List<ProductCategory> category = new ArrayList<>();
        // List<ProductSize> size = new ArrayList<>();
        // List<ProductBrand> brand = new ArrayList<>();
        // List<ProductColor> color = new ArrayList<>();
        // List<ProductAttribute> attributeSet = new ArrayList<>();
        // List<ProductType> productType = new ArrayList<>();
       
        // // json.get("category").forEach(itm -> category.add(new ProductCategory(itm)));
        // json.get("size").forEach(itm -> size.add(new ProductSize(itm)));
        // json.get("brand").forEach(itm -> brand.add(new ProductBrand(itm)));
        // json.get("color").forEach(itm -> color.add(new ProductColor(itm)));
        // json.get("attributeSet").forEach(itm -> attributeSet.add(new ProductAttribute(itm)));
        // json.get("productType").forEach(itm -> productType.add(new ProductType(itm)));


        // productAttributeRepository.saveAll(attributeSet);
        // productBrandRepo.saveAll(brand);
        // productColorRepo.saveAll(color);
        // productSizeRepo.saveAll(size);
        // productTypeRepository.saveAll(productType);


        
    }

}
