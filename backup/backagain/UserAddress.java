package com.spirngauth.authentication_spring.models;

import jakarta.validation.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_address")
public class UserAddress {
    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Users.class)
    @JoinColumn(name = "id")
    private Set<Users> userId;

    @NotBlank
    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    private String telephone;

    private String mobile;

    public UserAddress(Set<Users> userId, String addressLine1, String addressLine2, String city, String postalCode, String country, String telephone, String mobile) {
        this.userId = userId;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.telephone = telephone;
        this.mobile = mobile;
    }

    public UserAddress() {
    }

    public Set<Users> getUserId() {
        return userId;
    }

    public void setUserId(Set<Users> userId) {
        this.userId = userId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userId=" + userId +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
