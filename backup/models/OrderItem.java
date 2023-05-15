package com.spirngauth.authentication_spring.models;

import java.time.ZonedDateTime;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;

@Document("order_items")
public class OrderItem {
    @Id
    private String id;

    @DBRef
    @Field("order_id")
    private Set<OrderDetails> orderId;

    @DBRef
    @Field("product_id")
    private Set<Product> productId;

    private Number quantity;

    @Field("created_at")
    @CreatedDate
    private ZonedDateTime createdAt;
    @Field("modified_at")
    @LastModifiedDate
    private ZonedDateTime modifiedAt;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<OrderDetails> getOrderDetail() {
        return orderId;
    }

    public void setOrderDetail(Set<OrderDetails> orderId) {
        this.orderId = orderId;
    }

    public Set<Product> getProduct() {
        return productId;
    }

    public void setProduct(Set<Product> productId) {
        this.productId = productId;
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
