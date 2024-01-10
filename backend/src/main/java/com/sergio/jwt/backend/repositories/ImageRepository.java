package com.sergio.jwt.backend.repositories;//package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    // Lấy danh sách tất cả image theo thời gian tạo giảm dần
    List<Image> findByOrderByCreatedAtDesc();
}