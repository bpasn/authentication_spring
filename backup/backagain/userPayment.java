package com.spirngauth.authentication_spring.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_payment")
public class userPayment {
    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Users.class)
    @JoinColumn(name = "id")
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "payment_type")
    private String paymentType;

    private String provider;

    @Column(name = "account_no")
    private int accountNo;

    private Date expiry;

    public userPayment() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "userPayment{" +
                "id=" + id +
                ", userId=" + userId +
                ", paymentType='" + paymentType + '\'' +
                ", provider='" + provider + '\'' +
                ", accountNo=" + accountNo +
                ", expiry=" + expiry +
                '}';
    }
}
