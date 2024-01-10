package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.entites.Category;
import com.sergio.jwt.backend.entites.Tag;
import com.sergio.jwt.backend.repositories.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    public TagRepo tagRepo;


    public Optional<Tag> findById(int id) {
        return tagRepo.findById(id);
    }

    public List<Tag> findAll() {
        return tagRepo.findAll();
    }

    public Tag addTag(Tag c) {
        return tagRepo.save(c);
    }

    public void deleteTag(int id) {
        tagRepo.deleteById(id);
    }

}
