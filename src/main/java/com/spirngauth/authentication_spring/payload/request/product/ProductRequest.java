package com.spirngauth.authentication_spring.payload.request.product;

import java.util.List;

import com.spirngauth.authentication_spring.models.Discount;
import com.spirngauth.authentication_spring.models.ProductCategory;
import com.spirngauth.authentication_spring.models.ProductInventory;

public class ProductRequest{
    private String name;
    private String desc;
    private String SKU;

    private List<ProductCategory> category;
    private List<ProductInventory> inventory;
    private Double price;
    private List<Discount> discountPercent;
    
    @Override
    public String toString() {
        return "ProductRequest [name=" + name + ", desc=" + desc + ", SKU=" + SKU + ", category=" + category
                + ", price=" + price + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String sKU) {
        SKU = sKU;
    }

    public List<ProductCategory> getCategory() {
        return category;
    }

    public void setCategory(List<ProductCategory> category) {
        this.category = category;
    }

    public List<ProductInventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<ProductInventory> inventory) {
        this.inventory = inventory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Discount> getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(List<Discount> discountPercent) {
        this.discountPercent = discountPercent;
    }

   
    

    
    
    
    
}
