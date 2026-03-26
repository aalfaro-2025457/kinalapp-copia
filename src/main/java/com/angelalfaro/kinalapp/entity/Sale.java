package com.angelalfaro.kinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeSale;

    @Column(nullable = false, updatable = false)
    private LocalDateTime saleDateSale;

    @Column
    private BigDecimal totalSale;

    @Column
    private int stateSale;

    @ManyToOne
    @JoinColumn(name = "dpi_client", foreignKey = @ForeignKey(name = "FK_client"))
    private Client clientSale;

    @ManyToOne
    @JoinColumn(name = "codeUser", foreignKey = @ForeignKey(name = "FK_user"))
    private User userSale;

    @OneToMany(mappedBy = "saleDetailSale", cascade = CascadeType.ALL)
    private List<DetailSale> detailSalesSale;

}
