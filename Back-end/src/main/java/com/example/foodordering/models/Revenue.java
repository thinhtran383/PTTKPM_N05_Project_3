package com.example.foodordering.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Revenues")
@RequiredArgsConstructor
@Data
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RevenueID")
    private Long id;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;
}
