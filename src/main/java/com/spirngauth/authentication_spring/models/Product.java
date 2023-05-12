package com.spirngauth.authentication_spring.models;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;

@Document("products")
public class Product {
    @Id
    private String id;
    private String name;
    private String desc;
    private String SKU; // ประเภทสินค้า
    
    @DBRef
    private Set<ProductCategory> categoryId;

    @DBRef
    private Set<ProductInventory> inventoryId;

    private BigDecimal price;

    @DBRef
    private Set<Discount> discountId;

    @Field("created_at")
    @CreatedDate
    private ZonedDateTime createdAt;
    @Field("modified_at")
    @LastModifiedDate
    private ZonedDateTime modifiedAt;
    @Field("deleted_at")
    private ZonedDateTime deletedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public Set<ProductCategory> getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Set<ProductCategory> categoryId) {
        this.categoryId = categoryId;
    }

    public Set<ProductInventory> getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Set<ProductInventory> inventoryId) {
        this.inventoryId = inventoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Discount> getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Set<Discount> discountId) {
        this.discountId = discountId;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(ZonedDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public ZonedDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(ZonedDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    

    

}
