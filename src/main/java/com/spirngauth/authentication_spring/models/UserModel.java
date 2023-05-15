package com.spirngauth.authentication_spring.models;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document("users")
public class UserModel {
    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private String firstName;

    private String lastName;

    private String telephone;

    public String getFirstName() {
        return firstName;
    }

    @NotBlank
    @Size(max = 120)
    private String password;

    // @DocumentReference(lazy = true)
    @DBRef
    private Set<RoleModel> userRole = new HashSet<>();

    @CreatedDate
    @Field("created_at")
    private ZonedDateTime createdAt;

    @LastModifiedDate
    @Field("modified_at")
    private ZonedDateTime modifiedAt;

    public UserModel() {
    }

    public UserModel(
            String username,
            String email,
            String firstName,
            String lastName,
            String telephone,
            String password
            ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<RoleModel> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<RoleModel> userRole) {
        this.userRole = userRole;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(ZonedDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", firstName=" + firstName
                + ", lastName=" + lastName + ", telephone=" + telephone + ", password=" + password + ", userRole="
                + userRole + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + "]";
    }

    

}
