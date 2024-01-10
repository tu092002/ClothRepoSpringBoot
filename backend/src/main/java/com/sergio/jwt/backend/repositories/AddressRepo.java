package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Integer> {
    public interface AddressRepository extends JpaRepository<Address, Long> {
        @Query("SELECT a FROM Address a WHERE a.addressUsers = ?1")
        List<Address> findByUserId(Long userId);
    }

}
