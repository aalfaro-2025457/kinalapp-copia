package com.angelalfaro.kinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "detail_sales")
public class DetailSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeDetailSale;

    @Column(nullable = false)
    private int amountDetailSale;

    @Column(nullable = false)
    private BigDecimal unitPriceDetailSale;

    @Column(nullable = false)
    private BigDecimal subtotal;

    @Column(nullable = false)
    private int stateDetailSale;

    @ToString.Exclude
    @JsonIgnoreProperties("detailSalesProduct")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codeProduct", foreignKey = @ForeignKey(name = "FK_product"), nullable = false)
    private Product productDetailProduct;

    @ToString.Exclude
    @JsonIgnoreProperties("detailSalesSale")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codeSale", foreignKey = @ForeignKey(name = "FK_sale"), nullable = false)
    private Sale saleDetailSale;

}
