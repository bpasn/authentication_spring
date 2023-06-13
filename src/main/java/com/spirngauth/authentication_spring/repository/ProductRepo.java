package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spirngauth.authentication_spring.models.Products;

public interface ProductRepo extends JpaRepository<Products, Long> {
    public interface FieldCount{
        public String getSku();
    }
    @Query(value ="SELECT LPAD(count(id)+1, 5, '0') AS Sku FROM products limit 1;", nativeQuery = true)
    FieldCount countProducts();
}
