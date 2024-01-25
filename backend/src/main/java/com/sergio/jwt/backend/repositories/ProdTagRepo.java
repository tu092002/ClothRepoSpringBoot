package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.ProdTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProdTagRepo extends JpaRepository<ProdTag, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE  FROM ProdTag p WHERE p.product.id = :productId ")
    public void deleteByProdId(@Param("productId")int productId);
}
