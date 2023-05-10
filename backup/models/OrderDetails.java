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

@Document("order_details")
public class OrderDetails {
    @Id
    private String id;
    

    @DBRef
    @Field("user_id")
    private Set<UserModel> userId;

    private BigDecimal total;

    @DBRef
    @Field("payment_id")
    private Set<PaymentDetails> paymentId;

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
    public Set<UserModel> getUser() {
        return userId;
    }
    public void setUser(Set<UserModel> userId) {
        this.userId = userId;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public Set<PaymentDetails> getPaymentDetail() {
        return paymentId;
    }
    public void setPaymentDetail(Set<PaymentDetails> paymentId) {
        this.paymentId = paymentId;
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
