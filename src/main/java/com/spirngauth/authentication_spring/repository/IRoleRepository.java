package com.spirngauth.authentication_spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirngauth.authentication_spring.enums.ERole;
import com.spirngauth.authentication_spring.models.RoleModel;

public interface IRoleRepository extends JpaRepository<RoleModel,Long>{
    Optional<RoleModel> findByName(ERole name);
}
