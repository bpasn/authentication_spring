package com.spirngauth.authentication_spring.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document("users")
public class UserModel {
    @Id
    private String id;

    @NotBlank
    @Size(max =20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max=120)
    private String password;

    // @DocumentReference(lazy = true)
    @DBRef
    private Set<RoleModel> userRole = new HashSet<>();

    public UserModel(){}

    public  UserModel(
        String username,
        String email,
        String password
    ){
        this.username = username;
        this.email    = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleModel> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<RoleModel> userRole) {
        this.userRole = userRole;
    }


    
}
