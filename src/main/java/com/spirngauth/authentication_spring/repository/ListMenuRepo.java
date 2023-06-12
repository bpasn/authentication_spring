package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.ListMenu;

public interface ListMenuRepo extends JpaRepository<ListMenu,Long>{
    
}
