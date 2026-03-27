package com.angelalfaro.kinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeUser;

    @Column(nullable = false)
    private String usernameUser;

    @Column(nullable = false)
    private String passwordUser;

    @Column(nullable = false)
    private String emailUser;

    @Column(nullable = false)
    private String rolUser;

    @Column(nullable = false)
    private int stateUser;

    @OneToMany(mappedBy = "userSale", cascade = CascadeType.ALL)
    private List<Sale> salesUser;

}
