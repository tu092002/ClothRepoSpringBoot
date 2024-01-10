package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressUserRepo extends JpaRepository<Address, Integer> {
    @Query("SELECT a FROM AddressUser a WHERE a.user = ?1")
    List<Address> findByUserId(int userId);
}


