package com.sergio.jwt.backend.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)

@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @CreatedDate
    private LocalDateTime createdDate;


//    @OneToMany(fetch = FetchType.EAGER,mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<UserRole> userRoles = new LinkedHashSet<>();
    @OneToMany(mappedBy = "role")
    private Set<UserRole> roleUsers;
}
