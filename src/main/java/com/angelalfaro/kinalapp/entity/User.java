package com.angelalfaro.kinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "usurs")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID codeUser;

    @Column
    private String usernameUser;

    @Column
    private String passwordUser;

    @Column
    private String emailUser;

    @Column
    private String rolUser;

    @Column
    private int stateUser;

    @OneToMany(mappedBy = "userSale", cascade = CascadeType.ALL)
    private List<Sale> salesUser;

}
