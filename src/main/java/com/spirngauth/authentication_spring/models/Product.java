package com.spirngauth.authentication_spring.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

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
    private Set<ProductCategory> categoryId;

    @DBRef
    private Set<ProductInventory> inventoryId;

    private BigDecimal price;

    @DBRef
    private Set<Discount> discountId;

    @Field("created_at")
    @CreatedDate
    private Date createdAt = new Date();
    @Field("modified_at")
    
    @LastModifiedDate
    private Date modifiedAt;
    @Field("deleted_at")
    private Date deletedAt;

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
        return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", SKU=" + SKU + ", categoryId=" + categoryId
                + ", inventoryId=" + inventoryId + ", price=" + price + ", discountId=" + discountId + ", createdAt="
                + createdAt + ", modifiedAt=" + modifiedAt + ", deletedAt=" + deletedAt + "]";
    }

    

    

    

}
