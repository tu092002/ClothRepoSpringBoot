package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Category;
import com.sergio.jwt.backend.entites.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepo extends JpaRepository<Tag,Integer> {
    @Query("SELECT c FROM Tag c WHERE c.tagName LIKE %?1%")
    List<Tag> searchTagByName(String keyword);
}
