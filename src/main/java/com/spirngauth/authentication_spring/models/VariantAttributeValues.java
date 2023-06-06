package com.spirngauth.authentication_spring.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "variant_attribute_values")
public class VariantAttributeValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long variantAttributeValueId;

    @JoinTable(name = "attribute_value",joinColumns = @JoinColumn(name = "id"))
    private Long attributeValueId;

    public Long getVariantAttributeValueId() {
        return variantAttributeValueId;
    }

    public void setVariantAttributeValueId(Long variantAttributeValueId) {
        this.variantAttributeValueId = variantAttributeValueId;
    }

    public Long getAttributeValueId() {
        return attributeValueId;
    }

    public void setAttributeValueId(Long attributeValueId) {
        this.attributeValueId = attributeValueId;
    }

    



}
