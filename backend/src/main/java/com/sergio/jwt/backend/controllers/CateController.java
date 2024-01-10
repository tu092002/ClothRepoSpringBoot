package com.sergio.jwt.backend.controllers;

import com.sergio.jwt.backend.entites.Category;
import com.sergio.jwt.backend.repositories.CategoryRepo;
import com.sergio.jwt.backend.services.CategoryService;
import com.sergio.jwt.backend.services.ImageService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CateController {
    @Autowired
    public  CategoryService categoryService;
    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }


    // add cate
    @PostMapping("")
    public ResponseEntity<?> addCate(@RequestBody Category  category ) {
        return new ResponseEntity<>(categoryService.addCate(category), HttpStatus.CREATED);
    }


    // delete cate
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCate(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build(); // 204
    }

}
