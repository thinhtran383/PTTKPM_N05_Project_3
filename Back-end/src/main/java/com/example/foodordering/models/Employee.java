package com.example.foodordering.models;

import com.example.foodordering.constant.EmployeeRole;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Employees")
@RequiredArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private Long id;

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Role", nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;
}
