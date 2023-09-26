package com.example.foodordering.controller.WebController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodordering.DTO.ResponseObject;
import com.example.foodordering.DTO.RevenueDTO;
import com.example.foodordering.services.WebServices.RevenueService;

@RestController
@RequestMapping("/api")
public class RevenueController {

    private final RevenueService revenueService;

    @Autowired
    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @GetMapping("/revenue")
    public ResponseEntity<List<RevenueDTO>> getMonthlyRevenue(@RequestParam("year") int year) {
        try {
            List<RevenueDTO> monthlyRevenue = revenueService.getMonthlyRevenue(year);
            return ResponseEntity.ok(monthlyRevenue);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/revenue/weekly")
    public ResponseEntity<List<RevenueDTO>> getWeeklyRevenue(
            @RequestParam("month") int month,
            @RequestParam("year") int year) {
        try {
            List<RevenueDTO> weeklyRevenue = revenueService.getWeeklyRevenue(month, year);
            return ResponseEntity.ok(weeklyRevenue);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}