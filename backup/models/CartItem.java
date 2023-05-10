package com.spirngauth.authentication_spring.models;

import java.time.ZonedDateTime;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;

@Document("cart_item")
public class CartItem {
    @Id
    private String id;

    @DBRef
    @Field("session_id")
    private Set<ShoppingSession> sessionId;

    @DBRef
    private Set<Product> product;

    private Number quantity;

    @CreatedDate
    @Field("created_at")
    private ZonedDateTime createdAt;

    @LastModifiedDate
    @Field("modified_at")
    private ZonedDateTime modifiedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<ShoppingSession> getShoppingSession() {
        return sessionId;
    }

    public void setShoppingSession(Set<ShoppingSession> sessionId) {
        this.sessionId = sessionId;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
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

}
