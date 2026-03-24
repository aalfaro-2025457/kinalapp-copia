package com.angelalfaro.kinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID codeProduct;

    @Column
    private String nameProduct;

    @Column
    private double priceProduct;

    @Column
    private int stockProduct;

    @Column
    private int stateProduct;

}
