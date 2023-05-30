package com.spirngauth.authentication_spring.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

public class ProductOption {
    
    
    @DBRef()
    private List<ProductCategory> categories;
    @DBRef()
    private List<ProductAttribute> attributes;
    @DBRef()
    private List<ProductSize> sizes;
    @DBRef()
    private List<ProductType> productTypes;
    @DBRef()
    private List<ProductBrand> brands;
    @DBRef()
    private List<ProductColor> colors;
    public List<ProductCategory> getCategories() {
        return categories;
    }
    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }
    public List<ProductAttribute> getAttributes() {
        return attributes;
    }
    public void setAttributes(List<ProductAttribute> attributes) {
        this.attributes = attributes;
    }
    public List<ProductSize> getSizes() {
        return sizes;
    }
    public void setSizes(List<ProductSize> sizes) {
        this.sizes = sizes;
    }
    public List<ProductType> getProductTypes() {
        return productTypes;
    }
    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;
    }
    public List<ProductBrand> getBrands() {
        return brands;
    }
    public void setBrands(List<ProductBrand> brands) {
        this.brands = brands;
    }
    public List<ProductColor> getColors() {
        return colors;
    }
    public void setColors(List<ProductColor> colors) {
        this.colors = colors;
    }

    
    
    
    
}
