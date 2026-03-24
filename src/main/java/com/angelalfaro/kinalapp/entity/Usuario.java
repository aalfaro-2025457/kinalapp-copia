package com.angelalfaro.kinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "usuers")
public class Usuario {

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

}
