package com.spirngauth.authentication_spring.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import javax.validation.constraints.Size;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    // @Column(length = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    // @Column(length = 20)
    private String email;

    @NotBlank
    @Size(max = 120)
    // @Column(length = 120)
    private String password;

    @NotBlank
    @Size(max = 50)
    // @Column(length = 20)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    // @Column(length = 20)
    private String lastName;


    @NotBlank
    @Size(max = 20)
    private String telephone;

    @DBRef
	private Set<RoleModel> roles = new HashSet<>();
    


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt = new Date();;

    private Date deletedAt;


    

    public UserModel() {

    }
    
    
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", firstName=" + firstName +
                '}';
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
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


    public String getFirstName() {
        return firstName;
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

    public Set<RoleModel> getRoles() {
        return roles;
    }


    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
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


    public UserModel(@NotBlank String username, @NotBlank @Email String email, @NotBlank String password,
            @NotBlank String firstName, @NotBlank String lastName, @NotBlank String telephone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    
}
