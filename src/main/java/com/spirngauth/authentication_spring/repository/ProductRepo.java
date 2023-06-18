package com.spirngauth.authentication_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spirngauth.authentication_spring.models.Products;

import java.util.List;

public interface ProductRepo extends JpaRepository<Products, Long> {

    public interface FieldCount{
        public String getSku();
    }
    public interface  FieldProductCate {
        public String getId();
        public String getImage();
        public String getProductName();
        public String getCategoryName();
        public String getSku();
        public String getPrice();
        public String getQuantity();
        public String getActive();

    }
    @Query(value ="SELECT LPAD(count(id)+1, 5, '0') AS Sku FROM products limit 1;", nativeQuery = true)
    FieldCount countProducts();

    @Query(value = """
            SELECT
            p.id,
            REPLACE(c.image_path,"src/main/resources/storage","") as image,
            p.product_name as productName,
            CONCAT( UPPER(SUBSTR(c.category_name,1,1)),SUBSTR(category_name,2)) as categoryName,
            p.sku as Sku,
            p.price,
            p.quantity,
            c.active
            FROM products p
            JOIN categories c on c.id = p.categories_id
             """,nativeQuery = true)
    List<FieldProductCate> products();
}
