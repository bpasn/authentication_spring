package com.spirngauth.authentication_spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.ERole;
import com.spirngauth.authentication_spring.models.RoleModel;

public interface IRoleRepository extends MongoRepository<RoleModel,Long>{
    Optional<RoleModel> findByName(ERole name);
}
