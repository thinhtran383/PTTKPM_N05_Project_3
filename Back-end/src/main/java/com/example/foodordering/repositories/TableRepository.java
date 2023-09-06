package com.example.foodordering.repositories;

import com.example.foodordering.constant.TableStatus;
import com.example.foodordering.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableRepository extends JpaRepository<Table, Long> {
    List<Table> findAllTableByStatus(TableStatus status);
}
