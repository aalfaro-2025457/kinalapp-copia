package com.angelalfaro.kinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeProduct;

    @Column
    private String nameProduct;

    @Column
    private BigDecimal priceProduct;

    @Column
    private int stockProduct;

    @Column
    private int stateProduct;

    @OneToMany(mappedBy = "productDetailProduct", cascade = CascadeType.ALL)
    private List<DetailSale> detailSalesProduct;

}
