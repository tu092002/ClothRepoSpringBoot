package com.sergio.jwt.backend.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "role_id", nullable = false)
//    private Role role;


    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "roleId",referencedColumnName = "id")
    private Role role;



}
