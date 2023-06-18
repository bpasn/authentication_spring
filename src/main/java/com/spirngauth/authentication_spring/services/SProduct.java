package com.spirngauth.authentication_spring.services;

import com.spirngauth.authentication_spring.interfaces.IProduct;
import com.spirngauth.authentication_spring.models.AttributeValues;
import com.spirngauth.authentication_spring.models.Attributes;
import com.spirngauth.authentication_spring.models.Categories;
import com.spirngauth.authentication_spring.models.Products;
import com.spirngauth.authentication_spring.payload.request.product.RequestProduct;
import com.spirngauth.authentication_spring.payload.response.ResPayload;
import com.spirngauth.authentication_spring.repository.AttributeRepo;
import com.spirngauth.authentication_spring.repository.AttributeValueRepo;
import com.spirngauth.authentication_spring.repository.CategoriesRepo;
import com.spirngauth.authentication_spring.repository.ProductRepo;
import com.spirngauth.authentication_spring.repository.ProductRepo.FieldCount;
import com.spirngauth.authentication_spring.repository.VariantsRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("sProduct")
public class SProduct implements IProduct {

    private static final Logger logger = LoggerFactory.getLogger(SProduct.class);

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private AttributeRepo attributeRepo;
    
    @Autowired
    private VariantsRepo variantsRepo;

    @Autowired
    private AttributeValueRepo attributeValueRepo;

    @Autowired
    private CategoriesRepo categoriesRepo;
    // private static Logger logger = LoggerFactory.getLogger(SProduct.class);

    public static final String message = "Product Controller";

    @Override
    public ResPayload getAllProduct() {
        ResPayload response = new ResPayload();
        List<ProductRepo.FieldProductCate> products = productRepo.products();
        response.setSuccess(true);
        response.setPayload(products.toArray());
        return response;
    }

    @Override
    public Optional<String> getProductByname(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getProductByname'");
    }

    @Override
    public ResPayload loadingPage() {
        List<Map<String, Object>> payload = new ArrayList<>();
        List<Attributes> attributes = attributeRepo.findAll();
        attributes.forEach((Attributes attr) -> {
            Map<String, Object> attrObj = setAttribute(attr);
            payload.add(attrObj);
        });

        return response(true, payload);
    }

    @Override
    public ResPayload createProduct(RequestProduct req) {

        Products nProducts = new Products();
        Categories nCategories = categoriesRepo.findByCategoryName(req.getCategoryName())
                .orElseThrow(() -> new RuntimeException("Not Found  Category Name"));

        nProducts.setProductName(req.getProductName());
        nProducts.setDescription(req.getDescription());
        nProducts.setShortDescription(req.getShortDescription());
        nProducts.setPrice(req.getPrice());
        nProducts.setStatus(req.getStatus());
        nProducts.setDiscount(req.getDiscount());
        nProducts.setQuantity(Integer.parseInt(req.getQuantity()));

        Set<Attributes> sAttributes = new HashSet<>();

        req.getAttributes().forEach(attribute -> {
            Set<AttributeValues> attributeValues = new HashSet<>();
            Attributes nAttribute = attributeRepo.findByAttributeName(attribute.getName())
                    .orElseThrow(() -> new RuntimeException("Not Found Attribute Name"));
            AttributeValues gAttributeV = attributeValueRepo.findAllByAttributeIdAndAttributeValue(nAttribute.getId(), attribute.getValue());
            attributeValues.add(gAttributeV);
            nAttribute.setAttributeValues(attributeValues);
            sAttributes.add(nAttribute);
        });
        nProducts.setAttributes(sAttributes);
        nProducts.setCategoriesId(nCategories.getId());

        nProducts.setSKU(generateSKU(nProducts));
        productRepo.save(nProducts);

        return response(true, "Product Create Successfully !");
    }

    @Override
    public String generateSKU(Products product) {
        String category = categoriesRepo.findById(product.getCategoriesId()).get().getCategoryName().substring(0, 3).toUpperCase();
        StringBuilder skuBuilder = new StringBuilder();
        skuBuilder.append(category);

        product.getAttributes().forEach(item -> {
            item.getAttributeValues().forEach(value -> {
                String v = value.getAttributeValue().length() > 4 ? value.getAttributeValue().substring(0, 2)
                        : value.getAttributeValue().substring(0, 1);
                skuBuilder.append("-" + item.getAttributeName().substring(0, 3) + v);
            });
        });
        FieldCount count = productRepo.countProducts();
        skuBuilder.append("-" + count.getSku());
        return skuBuilder.toString();
    }

    public ResPayload response(Boolean flg, Object payload) {
        ResPayload resPayload = new ResPayload();
        resPayload.setSuccess(flg);
        resPayload.setPayload(payload);
        return resPayload;
    }

    public ResPayload response(Boolean flg) {
        ResPayload resPayload = new ResPayload();
        resPayload.setSuccess(flg);
        return resPayload;
    }

    public Map<String, Object> setAttribute(Attributes attribute) {
        Map<String, Object> mapAttribute = new HashMap<>();
        List<AttributeValues> attVal = attributeValueRepo.findAllByAttributeId(attribute.getId());
        List<HashMap<String, String>> map = new ArrayList<>();
        attVal.forEach((AttributeValues val) -> {
            HashMap<String, String> valueMap = new HashMap<>();
            valueMap.put("name", val.getAttributeValue());
            valueMap.put("id", val.getId().toString());
            map.add(valueMap);
        });
        mapAttribute.put("name", attribute.getAttributeName());
        mapAttribute.put("id", attribute.getId().toString());
        mapAttribute.put("options", map);

        return mapAttribute;
    }
}
