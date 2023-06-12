package com.spirngauth.authentication_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.models.ListMenu;
import com.spirngauth.authentication_spring.models.RoleModel;

public interface ListMenuRepo extends JpaRepository<ListMenu,Long>{
   
}
