package com.sergio.jwt.backend.repositories;//package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Image;
import com.sergio.jwt.backend.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %?1%")
    List<Product>  searchProductByName(String kw);




}
