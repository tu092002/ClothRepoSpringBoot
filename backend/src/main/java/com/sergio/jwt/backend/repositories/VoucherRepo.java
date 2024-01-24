package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Category;
import com.sergio.jwt.backend.entites.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoucherRepo extends JpaRepository<Voucher,Integer> {
    @Query("SELECT c FROM Voucher c WHERE c.voucherCode LIKE %?1%")
    List<Voucher> searchVoucherByCode(String keyword);
}
