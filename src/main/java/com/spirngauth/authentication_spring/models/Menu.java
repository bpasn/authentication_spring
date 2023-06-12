package com.spirngauth.authentication_spring.models;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "menu_item")
public class Menu {
    
    @Id
    private Long id;

    private String headName;
    private String url;
    
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = ListMenu.class)
    private Set<ListMenu> listMenus = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<ListMenu> getListMenus() {
        return listMenus;
    }

    public void setListMenus(Set<ListMenu> listMenus) {
        this.listMenus = listMenus;
    }

   

    
    

}