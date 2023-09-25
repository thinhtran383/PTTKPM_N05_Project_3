package com.example.foodordering.controller.WebController;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodordering.services.WebServices.RevenueService;

@RestController
@RequestMapping("/api/revenue/amount")
public class RevenueController {

    private final RevenueService revenueService;

    @Autowired
    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @GetMapping("/day")
    public ResponseEntity<BigDecimal> getRevenueAmountByDay(@RequestParam("day") int day) {
        try {
            BigDecimal amount = revenueService.getTotalAmountByDay(day);
            return ResponseEntity.ok(amount);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/month")
    public ResponseEntity<BigDecimal> getRevenueAmountByMonth(@RequestParam("month") int month) {
        try {
            BigDecimal amount = revenueService.getTotalAmountByMonth(month);
            return ResponseEntity.ok(amount);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Similar method for querying by month can be added
}