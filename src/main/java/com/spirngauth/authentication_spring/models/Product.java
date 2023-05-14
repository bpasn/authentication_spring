package com.spirngauth.authentication_spring.models;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("products")
public class Product {
    @Id
    private String id;

    private String name;
    private String desc;
    private String SKU; // ประเภทสินค้า
    
    @DBRef
    private ProductCategory category;

    @DBRef
    private ProductInventory inventory;

    private Double price;

    @DBRef
    private Discount discount;

    @Field("created_at")
    @CreatedDate
    private Date createdAt = new Date();
    @Field("modified_at")
    
    @LastModifiedDate
    private Date modifiedAt = new Date();
    @Field("deleted_at")
    private Date deletedAt;
    public String getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getSKU() {
        return SKU;
    }
    public void setSKU(String sKU) {
        SKU = sKU;
    }
    public ProductCategory getCategory() {
        return category;
    }
    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    public ProductInventory getInventory() {
        return inventory;
    }
    public void setInventory(ProductInventory inventory) {
        this.inventory = inventory;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Discount getDiscount() {
        return discount;
    }
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getModifiedAt() {
        return modifiedAt;
    }
    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
    public Date getDeletedAt() {
        return deletedAt;
    }
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", SKU=" + SKU + ", category=" + category
                + ", inventory=" + inventory + ", price=" + price + ", discount=" + discount + ", createdAt="
                + createdAt + ", modifiedAt=" + modifiedAt + ", deletedAt=" + deletedAt + "]";
    }

    public Product() {
    }

    public Product(String name, String desc, String sKU, Double price) {
        this.name = name;
        this.desc = desc;
        SKU = sKU;
        this.price = price;
    }
    

    

    

}
