package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.User;
import org.springframework.data.jpa.repository.EntityGraph;

public interface UserRepo {
    @EntityGraph(attributePaths = {"roles"})
    User findByUsername(String username);
}
