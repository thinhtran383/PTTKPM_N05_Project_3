package com.example.foodordering.services.WebServices;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodordering.repositories.RevenueRepository;

@Service
public class RevenueService {

    private final RevenueRepository revenueRepository;

    @Autowired
    public RevenueService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public BigDecimal getTotalAmountByDay(int day) {
        return revenueRepository.getTotalAmountByDay(day);
    }

    public BigDecimal getTotalAmountByMonth(int month) {
        return revenueRepository.getTotalAmountByMonth(month);
    }

    // You can add more service methods as needed
}
