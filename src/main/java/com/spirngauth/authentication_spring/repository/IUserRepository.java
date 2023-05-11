package com.spirngauth.authentication_spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spirngauth.authentication_spring.models.UserModel;

public interface IUserRepository extends MongoRepository<UserModel,Long> {
    Optional<UserModel> findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
