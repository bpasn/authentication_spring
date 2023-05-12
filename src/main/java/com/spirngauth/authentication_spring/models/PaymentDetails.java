package com.spirngauth.authentication_spring.models;

import java.time.ZonedDateTime;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;

@Document("payment_detaild")
public class PaymentDetails {
    @Id
    @DBRef
    private Set<OrderDetails> id;

    private Number amount;
    private String provider;
    private String status;
    @Field("created_at")
    @CreatedDate
    private ZonedDateTime createdAt;
    @Field("modified_at")
    @LastModifiedDate
    private ZonedDateTime modifiedAt;
    

    public Set<OrderDetails> getId() {
        return id;
    }

    public void setId(Set<OrderDetails> id) {
        this.id = id;
    }

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
