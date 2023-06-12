package com.spirngauth.authentication_spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spirngauth.authentication_spring.models.ERole;
import com.spirngauth.authentication_spring.models.RoleModel;


public interface RoleRepository extends JpaRepository<RoleModel,String> {
    Optional<RoleModel> findByName(ERole name);
    Optional<RoleModel> findByName(String name);
}
