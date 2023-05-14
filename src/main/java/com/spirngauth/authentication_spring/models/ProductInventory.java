package com.spirngauth.authentication_spring.models;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;

@Document("product_inventory")
public class ProductInventory {
    @Id
    private String id;
    private Number quantity;
    @Field("created_at")
    @CreatedDate
    private Date createdAt = new Date();
    @Field("modified_at")
    @LastModifiedDate
    private Date modifiedAt = new Date();
    @Field("deleted_at")
    private Date deletedAt;
   
    public Number getQuantity() {
        return quantity;
    }
    public void setQuantity(Number quantity) {
        this.quantity = quantity;
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
        return "ProductInventory [id=" + id + ", quantity=" + quantity + ", createdAt=" + createdAt + ", modifiedAt="
                + modifiedAt + ", deletedAt=" + deletedAt + "]";
    }

    


}