package com.spirngauth.authentication_spring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "attribute_values")
public class AttributeValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private String attributeValue;

    @JoinColumn(name = "attribute_id",referencedColumnName = "id")
    private Long attributeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                ", attributeValue='" + attributeValue + '\'' +
                '}';
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }
}
