package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            "select u " +
                    "from User u " +
                    "left join fetch u.userRoles " +
                    "where u.username = :name "
    )
    User findByUsername(@Param("name") String username);




    //    @Query(
//            "select u " +
//                    "from User u " +
//                    "left join fetch u.userRoles "+
//                    "where u.username = :name"
//    )
//    User findByUsernameAndFetchRoles(@Param("name") String username);
    @Query(
            "select u " +
                    "from User u " +
                    "left join fetch u.userRoles ur " +
                    "left join fetch ur.role r " +
                    "where u.username = :username"
    )
    User findUserAndRolesByUsername(@Param("username") String username);


    @EntityGraph(value = "User.roles")
    User findById(int userId);
}
