package com.spirngauth.authentication_spring.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;
@Document("product_type")
public class ProductType {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;

    // private String desc;

    

    @Field("created_at")
    @CreatedDate
    private Date createdAt = new Date();

   

    public ProductType(String name) {
        this.name = name;
    }

    @Field("modified_at")
    @LastModifiedDate
    private Date modifiedAt = new Date();
    

    @Field("deleted_at")
    private Date deletedAt;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    // public String getDesc() {
    //     return desc;
    // }

    // public void setDesc(String desc) {
    //     this.desc = desc;
    // }

   
   

    @Override
    public String toString() {
        return "ProductCategory [id=" + id + ", name=" + name + ", createdAt=" + createdAt
                + ", modifiedAt=" + modifiedAt + ", deletedAt=" + deletedAt + "]";
    }

    
    
}
