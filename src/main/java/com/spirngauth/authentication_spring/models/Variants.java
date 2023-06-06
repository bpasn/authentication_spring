package com.spirngauth.authentication_spring.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
@Table(name = "variants")
public class Variants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinTable(name = "variant_attribute_values", joinColumns = @JoinColumn(name = "id"))
    private Long variantAttributeValueId;
    
    @JoinTable(name = "products", joinColumns = @JoinColumn(name = "id"))
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVariantAttributeValueId() {
        return variantAttributeValueId;
    }

    public void setVariantAttributeValueId(Long variantAttributeValueId) {
        this.variantAttributeValueId = variantAttributeValueId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    
}
