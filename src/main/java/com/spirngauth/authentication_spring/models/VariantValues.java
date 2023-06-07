package com.spirngauth.authentication_spring.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "variant_values")
public class VariantValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "variant_id")
    private Variants variantId;

    private Double price;
    private Number quantity;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Variants getVariantId() {
        return variantId;
    }
    public void setVariantId(Variants variantId) {
        this.variantId = variantId;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Number getQuantity() {
        return quantity;
    }
    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

   
}
