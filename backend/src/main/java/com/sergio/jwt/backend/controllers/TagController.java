package com.sergio.jwt.backend.controllers;

import com.sergio.jwt.backend.entites.Category;
import com.sergio.jwt.backend.entites.Tag;
import com.sergio.jwt.backend.repositories.CategoryRepo;
import com.sergio.jwt.backend.services.CategoryService;
import com.sergio.jwt.backend.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag/")
public class TagController {
    @Autowired
    public TagService tagService;


    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(tagService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(tagService.findById(id));
    }


    // add tag
    @PostMapping("")
    public ResponseEntity<?> addTag(@RequestBody Tag tag ) {
        return new ResponseEntity<>(tagService.addTag(tag), HttpStatus.CREATED);
    }


    // delete tag
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable Integer id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build(); // 204
    }

}
