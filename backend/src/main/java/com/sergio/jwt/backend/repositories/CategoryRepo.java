package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    @Query("SELECT c FROM Category c WHERE c.cateName LIKE %?1%")
    List<Category> searchCategoryByName(String keyword);
}
