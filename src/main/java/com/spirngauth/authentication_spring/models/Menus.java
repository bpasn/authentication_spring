package com.spirngauth.authentication_spring.models;


import java.util.HashSet;
import java.util.Set;

import groovy.transform.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "menus")
public class Menus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String headName;
    private String url;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "menu_item_list_menu",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "list_menu_id"))
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
