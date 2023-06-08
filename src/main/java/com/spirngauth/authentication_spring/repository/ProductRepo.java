package com.spirngauth.authentication_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spirngauth.authentication_spring.models.Products;

public interface ProductRepo extends JpaRepository<Products, Long> {
    public interface ProductField {
        String getId();

        String getProductName();

        String getProductDescription();

        String getShortDescription();

        String getStatus();

        String getSku();

        String getDiscount();

        String getPrice();

        Integer getQuantity();

        String getAttributeValue();
    }

    // @Query(value = """
    //                     SELECT
    //                     p.id,
    //                     p.product_name as productName,
    //                     p.product_description as productDescription,
    //                     p.short_description as shortDescription,
    //                     p.status,
    //                     p.sku,
    //                     p.discount,
    //                     p.price,
    //                     p.quantity,
    //                     select
    //                     FROM products as p
    //                     left join variants as v on v.product_id = p.id
    //                     left join variant_attribute_values vav on vav.variant_attribute_value_id = v.id
    //                     left join attribute_values attv on attv.id = vav.attribute_value_id
    //                         """, nativeQuery = true)
    // List<Products> findProducts();
}
