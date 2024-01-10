package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag,Integer> {

}
