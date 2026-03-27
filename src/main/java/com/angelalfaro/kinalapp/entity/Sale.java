package com.angelalfaro.kinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeSale;

    @Column(nullable = false, updatable = false)
    private LocalDateTime saleDateSale = LocalDateTime.now();

    @Column(nullable = false)
    private BigDecimal totalSale;

    @Column(nullable = false)
    private int stateSale;

    @JsonIgnoreProperties("salesClient")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dpi_client", foreignKey = @ForeignKey(name = "FK_client"), nullable = false)
    private Client clientSale;

    @JsonIgnoreProperties("salesUser")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codeUser", foreignKey = @ForeignKey(name = "FK_user"), nullable = false)
    private User userSale;

    @OneToMany(mappedBy = "saleDetailSale", cascade = CascadeType.ALL)
    private List<DetailSale> detailSalesSale;

}
