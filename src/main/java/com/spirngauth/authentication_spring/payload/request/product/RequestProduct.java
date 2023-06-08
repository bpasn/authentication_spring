package com.spirngauth.authentication_spring.payload.request.product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RequestProduct {
    private String productName;
    private String description;
    private String shortDescription;
    private List<Attribute> attributes;
    private String SKU;
    private String status;
    private String price;
    private String discount;
    private String quantity;

    public RequestProduct() {
    }

    @Override
    public String toString() {
        return "RequestProduct{" +
                "productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", attributes=" + attributes +
                ", SKU='" + SKU + '\'' +
                ", status='" + status + '\'' +
                ", price='" + price + '\'' +
                ", discount='" + discount + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String sKU) {
        SKU = sKU;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

   
}
