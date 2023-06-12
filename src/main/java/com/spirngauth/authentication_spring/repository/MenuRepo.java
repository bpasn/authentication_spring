package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.Menu;

public interface MenuRepo extends JpaRepository<Menu,Long>{
    
}
