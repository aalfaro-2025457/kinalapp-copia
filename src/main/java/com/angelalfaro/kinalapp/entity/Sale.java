package com.angelalfaro.kinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID codeSale;

    @Column(nullable = false)
    private LocalDateTime saleDateSale;

    @Column
    private double totalSale;

    @Column
    private int stateSale;

    @ManyToOne
    @JoinColumn(name = "dpi_client", foreignKey = @ForeignKey(name = "FK_client"))
    private Client clientSale;

    @ManyToOne
    @JoinColumn(name = "codeUser", foreignKey = @ForeignKey(name = "FK_user"))
    private User userSale;

}
