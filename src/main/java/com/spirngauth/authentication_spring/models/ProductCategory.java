package com.spirngauth.authentication_spring.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;

@Document("product_category")
public class ProductCategory {
    @Id
    private String id;

    private String name;

    private String desc;

    @Field("created_at")
    @CreatedDate
    private Date createdAt = new Date();

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "ProductCategory [id=" + id + ", name=" + name + ", desc=" + desc + ", createdAt=" + createdAt
                + ", modifiedAt=" + modifiedAt + ", deletedAt=" + deletedAt + "]";
    }

    
    

    
}
