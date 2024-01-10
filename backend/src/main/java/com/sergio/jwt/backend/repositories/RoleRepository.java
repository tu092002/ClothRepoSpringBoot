package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}

