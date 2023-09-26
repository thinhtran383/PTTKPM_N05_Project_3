package com.example.foodordering.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.foodordering.entity.Revenue;

public interface RevenueRepository extends JpaRepository<Revenue, Long> {

        // get amount every month in year
        @Query("SELECT MONTH(r.date) AS month, SUM(r.amount) AS totalAmount " +
                        "FROM Revenue r " +
                        "WHERE YEAR(r.date) = :year " +
                        "GROUP BY MONTH(r.date)")
        List<Object[]> getRevenueAmountsByMonthForYear(int year);
        // get amount every week in month , year

        @Query("SELECT " +
                        "CASE " +
                        "   WHEN DAY(r.date) <= (DAY(LAST_DAY(r.date)) / 4) THEN 1 " +
                        "   WHEN DAY(r.date) <= (DAY(LAST_DAY(r.date)) / 2) THEN 2 " +
                        "   WHEN DAY(r.date) <= (3 * DAY(LAST_DAY(r.date)) / 4) THEN 3 " +
                        "   ELSE 4 " +
                        "END AS week, " +
                        "SUM(r.amount) AS totalAmount " +
                        "FROM Revenue r " +
                        "WHERE MONTH(r.date) = :month AND YEAR(r.date) = :year " +
                        "GROUP BY week")
        List<Object[]> getRevenueAmountsByWeekForMonthAndYear(int month, int year);

}
