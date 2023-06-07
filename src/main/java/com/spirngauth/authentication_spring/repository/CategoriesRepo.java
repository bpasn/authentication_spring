package com.spirngauth.authentication_spring.repository;

import com.spirngauth.authentication_spring.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepo extends JpaRepository<Categories,Long> {
}
