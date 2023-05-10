package com.spirngauth.authentication_spring.models;

import java.time.ZonedDateTime;

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
    public Number getQuantity() {
        return quantity;
    }
    public void setQuantity(Number quantity) {
        this.quantity = quantity;
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