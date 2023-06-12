package com.spirngauth.authentication_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spirngauth.authentication_spring.models.Menus;

public interface MenuRepo extends JpaRepository<Menus,Long>{
    // public interface MenuField{
    //     public String getHeaderName();
    //     public String getUrl();
    //     public Long getId();
    // }
    // @Query("SELECT header_name as headerName, url , id from menus")
    // List<MenuField> findAllMenu();
}
