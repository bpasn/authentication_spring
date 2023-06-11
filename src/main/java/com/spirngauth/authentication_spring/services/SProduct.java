package com.spirngauth.authentication_spring.services;

import com.spirngauth.authentication_spring.services.interfaces.IProduct;
import com.spirngauth.authentication_spring.models.AttributeValues;
import com.spirngauth.authentication_spring.models.Attributes;
import com.spirngauth.authentication_spring.models.Products;
import com.spirngauth.authentication_spring.models.VariantValues;
import com.spirngauth.authentication_spring.models.Variants;
import com.spirngauth.authentication_spring.payload.request.product.Attribute;
import com.spirngauth.authentication_spring.payload.request.product.RequestProduct;
import com.spirngauth.authentication_spring.payload.response.ResPayload;
import com.spirngauth.authentication_spring.repository.AttributeRepo;
import com.spirngauth.authentication_spring.repository.AttributeValueRepo;
import com.spirngauth.authentication_spring.repository.ProductRepo;
import com.spirngauth.authentication_spring.repository.VariantsRepo;

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
    private VariantsRepo variantsRepo;

    @Autowired
    private AttributeValueRepo attributeValueRepo;

    // private static Logger logger = LoggerFactory.getLogger(SProduct.class);

    public static final String message = "Product Controller";

    @Override
    public ResPayload getAllProduct() {
        ResPayload response = new ResPayload();
        response.setSuccess(true);
        response.setPayload(productRepo.findAll());
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
        ResPayload resPayload = new ResPayload();
        Variants variants = new Variants();
        Set<VariantValues> variantVal = new HashSet<>();
        Products product = new Products();

        List<Attribute> gAttr = req.getAttributes();
        Set<Attributes> sAttr = new HashSet<>();

        gAttr.forEach((Attribute attr) -> {
            Attributes _attr = attributeRepo.findByAttributeName(attr.getName())
                    .orElseThrow(() -> new RuntimeException("Attribute Name Not Found!"));
            sAttr.add(_attr);
        });
        // product.setProductName(req.getProductName());
        // product.setDiscount(req.getDiscount());
        // product.setPrice(req.getPrice());
        // product.setProductDescription(req.getDescription());
        // product.setShortDescription(req.getShortDescription());
        // product.setSKU(req.getSKU());
        // product.setStatus(req.getStatus());
        // product.setQuantity(Integer.parseInt(req.getQuantity()));
        // product.setAttributes(sAttr);
        productRepo.save(product);
        Set<AttributeValues> sAttrVal = new HashSet<>();
        gAttr.forEach(attr -> {
            Attributes attributes = attributeRepo.findByAttributeName(attr.getName())
                    .orElseThrow(() -> new RuntimeException("Attribute Name Not Found"));
            AttributeValues attributeValues = attributeValueRepo
                    .findByAttributeValueAndAttributeId(attr.getValue(), attributes)
                    .orElseThrow(() -> new RuntimeException("Attribute Value Not Found"));
            sAttrVal.add(attributeValues);
        });
        variants.setProductId(product);
        variants.setAttributeValues(sAttrVal);
        variantsRepo.save(variants);

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

    public Map<String, Object> setAttribute(Attributes attribute) {
        Map<String, Object> mapAttribute = new HashMap<>();
        List<AttributeValues> attVal = attributeValueRepo.findAllByAttributeId(attribute);
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
