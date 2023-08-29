package com.example.foodordering.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Configuration;

@Entity
@Table(name = "Customers")
@AllArgsConstructor
@ToString
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Long id;
    @Column(name = "Phone", nullable = false)
    private String phone;
    @Column(name = "Name", nullable = false)
    private String name;
}
