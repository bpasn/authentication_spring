package com.spirngauth.authentication_spring.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String SKU;
    private String price;
    private String discount;
    private Number quantity;
    private String status;
    private String shortDescription;
    private String productDescription;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_attributes", joinColumns = @JoinColumn(name = "attribute_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Attributes> attributes = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String sKU) {
        SKU = sKU;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Set<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attributes> attributes) {
        this.attributes = attributes;
    }

    // public LocalDateTime getCreatedAt() {
    //     return createdAt;
    // }

    // public void setCreatedAt(LocalDateTime createdAt) {
    //     this.createdAt = createdAt;
    // }

    // public LocalDateTime getUpdatedAt() {
    //     return updatedAt;
    // }

    // public void setUpdatedAt(LocalDateTime updatedAt) {
    //     this.updatedAt = updatedAt;
    // }

    

}
