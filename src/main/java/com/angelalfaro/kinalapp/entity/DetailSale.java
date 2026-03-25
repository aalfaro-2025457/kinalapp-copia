package com.angelalfaro.kinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "detail_sales")
public class DetailSale {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID codeDetailSale;

    @Column
    private int amountDetailSale;

    @Column
    private double unitPriceDetailSale;

    @Column
    private double subtotal;

    @Column
    private int stateDetailSale;

    @ManyToOne
    @JoinColumn(name = "codeProduct", foreignKey = @ForeignKey(name = "FK_product"))
    private Product productDetailProduct;

    @ManyToOne
    @JoinColumn(name = "codeSale", foreignKey = @ForeignKey(name = "FK_sale"))
    private Sale saleDetailSale;

}
