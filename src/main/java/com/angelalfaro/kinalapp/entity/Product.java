package com.angelalfaro.kinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeProduct;

    @Column(nullable = false)
    private String nameProduct;

    @Column(nullable = false)
    private BigDecimal priceProduct;

    @Column(nullable = false)
    private int stockProduct;

    @Column(nullable = false)
    private int stateProduct;

    @OneToMany(mappedBy = "productDetailProduct", cascade = CascadeType.ALL)
    private List<DetailSale> detailSalesProduct;

}
