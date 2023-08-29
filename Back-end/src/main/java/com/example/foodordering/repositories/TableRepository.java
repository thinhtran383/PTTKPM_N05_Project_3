package com.example.foodordering.repositories;

import com.example.foodordering.models.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
