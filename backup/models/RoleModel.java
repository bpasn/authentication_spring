package com.spirngauth.authentication_spring.models;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("roles")
public class RoleModel {
    @Id
    private String id;

    private ERole name;

    public RoleModel(){}
    public RoleModel(ERole name){
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public ERole getName() {
        return name;
    }
    public void setName(ERole name) {
        this.name = name;
    }
    
}
