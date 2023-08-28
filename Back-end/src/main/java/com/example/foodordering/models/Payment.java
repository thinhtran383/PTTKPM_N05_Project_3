package com.example.foodordering.models;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Payments")
@RequiredArgsConstructor
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ReservationID")
    private Reservation reservation;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;
}
