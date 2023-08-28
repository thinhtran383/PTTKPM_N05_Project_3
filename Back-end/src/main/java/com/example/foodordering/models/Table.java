package com.example.foodordering.models;

import com.example.foodordering.constant.TableStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@jakarta.persistence.Table(name = "Tables")
@RequiredArgsConstructor
@Data
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TableID")
    private Long id;

    @Column(name = "TableNumber", nullable = false)
    private int tableNumber;

    @Column(name = "Capacity", nullable = false)
    private int capacity;

    @Column(name = "Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TableStatus status;

}
