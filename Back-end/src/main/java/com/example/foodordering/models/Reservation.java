package com.example.foodordering.models;

import com.example.foodordering.constant.ReservationStatus;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@RequiredArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReservationId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "TableID")
    private com.example.foodordering.models.Table table;

    @Column(name = "ReservationTime", nullable = false)
    private LocalDateTime reservationTime;

    @Column(name = "Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
}
