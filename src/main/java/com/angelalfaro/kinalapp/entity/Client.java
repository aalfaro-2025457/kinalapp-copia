package com.angelalfaro.kinalapp.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name="clients")
public class Client {

    @Column(name="dpi_client", nullable = false)
    @Id
    private String DPIClient;

    @Column(nullable = false)
        private String nameClient;

    @Column(nullable = false)
    private String lastNameClient;

    @Column(nullable = false)
    private String direction;

    @Column(nullable = false)
    private int state;

    @ToString.Exclude
    @OneToMany(mappedBy = "clientSale", cascade = CascadeType.ALL)
    private List<Sale> salesClient;

}
