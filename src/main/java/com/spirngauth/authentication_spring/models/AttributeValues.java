package com.spirngauth.authentication_spring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "attribute_values")
public class AttributeValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id")
    private Attributes attributeId;

    private String attributeValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Attributes getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Attributes attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    @Override
    public String toString() {
        return "AttributeValues{" +
                "id=" + id +
                ", attributeId=" + attributeId +
                ", attributeValue='" + attributeValue + '\'' +
                '}';
    }
}
