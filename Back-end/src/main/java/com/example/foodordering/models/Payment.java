package com.example.foodordering.models;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "Payments")
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
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
