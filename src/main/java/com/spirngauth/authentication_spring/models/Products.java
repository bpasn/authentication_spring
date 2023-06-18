package com.spirngauth.authentication_spring.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "product_name"),
        @UniqueConstraint(columnNames = "sku"),
})
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="product_name",unique=true)
    private String productName;

    @Column(name="sku",unique=true)
    private String SKU;

    private String price;
    private String discount;
    private Integer quantity;
    private String status;
    private String shortDescription;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Attributes.class)
    @JoinTable(name = "product_attribute", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private Set<Attributes> attributes = new HashSet<>();

    @JoinColumn(name = "categories_id",referencedColumnName = "id")
    private Long categoriesId;
//    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER,targetEntity = Categories.class)
//    @JoinColumn(name="categories_id")
//    private Categories categories;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Set<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attributes> attributes) {
        this.attributes = attributes;
    }

    public Long getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Long categoriesId) {
        this.categoriesId = categoriesId;
    }

    //    public Categories getCategories() {
//        return categories;
//    }
//
//    public void setCategories(Categories categories) {
//        this.categories = categories;
//    }

}
