package com.sergio.jwt.backend.repositories;//package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
