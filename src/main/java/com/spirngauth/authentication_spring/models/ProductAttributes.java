package com.spirngauth.authentication_spring.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

@Table(name ="product_attributes")
public class ProductAttributes {

    @JoinTable(name = "products", joinColumns = @JoinColumn(name = "id"))
    private Long productId;

    
    @JoinTable(name = "attributes", joinColumns = @JoinColumn(name = "id"))
    private Long attributeId;
}
