package com.angelalfaro.kinalapp.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="clients")
public class Client {

    @Column(name="dpi_client")
    @Id
    private String DPIClient;
    @Column
    private String nameClient;
    @Column
    private String lastNameClient;
    @Column
    private String direction;
    @Column
    private int state;

    @OneToMany(mappedBy = "clientSale", cascade = CascadeType.ALL)
    private List<Sale> salesClient;

}
