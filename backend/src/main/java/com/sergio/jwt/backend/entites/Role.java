package com.sergio.jwt.backend.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;


//    @OneToMany(fetch = FetchType.EAGER,mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<UserRole> userRoles = new LinkedHashSet<>();
    @OneToMany(mappedBy = "role")
    private Set<UserRole> roleUsers;
}
