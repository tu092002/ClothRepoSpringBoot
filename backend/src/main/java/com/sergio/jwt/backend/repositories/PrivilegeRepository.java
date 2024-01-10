package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
    Privilege findByName(String name);
}

