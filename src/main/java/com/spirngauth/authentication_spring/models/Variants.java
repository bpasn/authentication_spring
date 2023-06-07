package com.spirngauth.authentication_spring.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "variants")
public class Variants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "variant_attribute_values", joinColumns = @JoinColumn(name = "variant_attribute_value_id"), inverseJoinColumns = @JoinColumn(name = "attribute_value_id"))
    private Set<VariantAttributeValues> variantAttributeValueId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Products productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<VariantAttributeValues> getVariantAttributeValueId() {
        return variantAttributeValueId;
    }

    public void setVariantAttributeValueId(Set<VariantAttributeValues> variantAttributeValueId) {
        this.variantAttributeValueId = variantAttributeValueId;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    
}
