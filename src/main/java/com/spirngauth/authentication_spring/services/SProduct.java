package com.spirngauth.authentication_spring.services;

import com.spirngauth.authentication_spring.interfaces.IProduct;
import com.spirngauth.authentication_spring.models.AttributeValues;
import com.spirngauth.authentication_spring.models.Attributes;
import com.spirngauth.authentication_spring.models.Products;
import com.spirngauth.authentication_spring.payload.request.product.Attribute;
import com.spirngauth.authentication_spring.payload.request.product.RequestProduct;
import com.spirngauth.authentication_spring.payload.response.BaseResponse;
import com.spirngauth.authentication_spring.payload.response.ResPayload;
import com.spirngauth.authentication_spring.repository.AttributeRepo;
import com.spirngauth.authentication_spring.repository.AttributeValueRepo;
import com.spirngauth.authentication_spring.repository.ProductRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("sProduct")
public class SProduct implements IProduct {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeValueRepo attributeValueRepo;

    private static Logger logger = LoggerFactory.getLogger(SProduct.class);

    public static final String message = "Product Controller";

    @Override
    public List<Products> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Optional<String> getProductByname(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductByname'");
    }

    @Override
    public ResPayload loadingPage() {
        List<Map<String, Object>> payload = new ArrayList<>();
        List<Attributes> attributes = attributeRepo.findAll();
        attributes.forEach((Attributes attr) -> {
            Map<String, Object> mapOb = new HashMap<>();
            List<AttributeValues> attVal = attributeValueRepo.findByAttributeId(attr);
            List<HashMap<String, String>> map = new ArrayList<>();
            attVal.forEach((AttributeValues val) -> {
                HashMap<String, String> valueMap = new HashMap<>();
                valueMap.put("name", val.getAttributeValue());
                valueMap.put("id", val.getId().toString());
                map.add(valueMap);
            });
            mapOb.put("name", attr.getAttributeName());
            mapOb.put("id", attr.getId().toString());
            mapOb.put("options", map);
            payload.add(mapOb);
        });

        return response(true, payload);
    }

    @Override
    public ResPayload createProduct(RequestProduct req) {
        ResPayload resPayload = new ResPayload();
        
        
        List<Attribute> gAttr = req.getAttributes();
        Set<Attributes> sAttr = new HashSet<>();
        gAttr.forEach((Attribute attr) -> {
            Attributes _attr = attributeRepo.findByAttributeName(attr.getName()).orElseThrow(() -> new RuntimeException("Attribute Name Not Found!"));
            sAttr.add(_attr);
        });
        Products product = new Products();
        product.setProductName(req.getProductName());
        product.setDiscount(req.getDiscount());
        product.setPrice(req.getPrice());
        product.setProductDescription(req.getDescription());
        product.setShortDescription(req.getShortDescription());
        product.setSKU(req.getSKU());
        product.setStatus(req.getStatus());
        product.setQuantity(Integer.parseInt(req.getQuatity()));
        product.setAttributes(sAttr);
        productRepo.save(product);
        return resPayload;
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

}
