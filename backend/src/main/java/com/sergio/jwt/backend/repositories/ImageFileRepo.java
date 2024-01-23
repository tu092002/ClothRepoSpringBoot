package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.ImageFile;
import com.sergio.jwt.backend.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageFileRepo extends JpaRepository<ImageFile, Integer> {


}
