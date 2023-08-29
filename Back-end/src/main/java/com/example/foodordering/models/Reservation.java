package com.example.foodordering.models;

import com.example.foodordering.constant.ReservationStatus;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
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
