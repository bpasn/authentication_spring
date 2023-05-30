package com.spirngauth.authentication_spring.models;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("product_image")
public class ProductImage {
    @Id
    private String id;

    private List<String> images;

    private String attibuteSet;
    private String productType;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<String> getImages() {
        return images;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }
    public String getAttibuteSet() {
        return attibuteSet;
    }
    public void setAttibuteSet(String attibuteSet) {
        this.attibuteSet = attibuteSet;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }

    
}