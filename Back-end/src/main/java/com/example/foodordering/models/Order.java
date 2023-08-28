package com.example.foodordering.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Cleanup;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Orders")
@RequiredArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Long id;

    @ManyToOne
    @JoinColumn (name = "ReservationID")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "MenuItemID")
    private MenuItem menuItem;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

}
