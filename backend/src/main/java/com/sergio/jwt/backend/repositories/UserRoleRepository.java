package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {


}
