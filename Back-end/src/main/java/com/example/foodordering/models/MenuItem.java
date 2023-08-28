package com.example.foodordering.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Cleanup;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "MenuItems")
@RequiredArgsConstructor
@Data
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MenuItemID")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Column(name = "QuantityRemaining", nullable = false)
    private int quantityRemaining;


}
