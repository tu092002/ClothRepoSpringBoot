package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
