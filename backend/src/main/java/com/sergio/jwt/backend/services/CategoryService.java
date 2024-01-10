package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.entites.Category;
import com.sergio.jwt.backend.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public Optional<Category> findById(int id) {
        return categoryRepo.findById(id);
    }

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category addCate(Category c) {
        return categoryRepo.save(c);
    }

    public void delete(int id) {
        categoryRepo.deleteById(id);
    }


}
