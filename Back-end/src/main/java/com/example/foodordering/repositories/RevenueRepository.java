package com.example.foodordering.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.foodordering.entity.Revenue;

public interface RevenueRepository extends JpaRepository<Revenue, Long> {

    // Custom query method to get total amount by day
    @Query("SELECT SUM(r.amount) FROM Revenue r WHERE DAY(r.date) = :day")
    BigDecimal getTotalAmountByDay(int day);

    // Custom query method to get total amount by month
    @Query("SELECT SUM(r.amount) FROM Revenue r WHERE MONTH(r.date) = :month")
    BigDecimal getTotalAmountByMonth(int month);

    // You can add more custom query methods as needed
}
