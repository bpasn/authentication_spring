package com.spirngauth.authentication_spring.repository;

import com.spirngauth.authentication_spring.models.Categories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoriesRepo extends JpaRepository<Categories,Long> {

    Optional<Categories> findByCategoryName(String categoryName);
    
    @Query(value = "SELECT * FROM categories limit ?1 , ?2",nativeQuery = true)
    public List<Categories> findCategories(int offset,int limit);
}
