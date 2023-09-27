package com.example.foodordering.services.WebServices;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodordering.DTO.RevenueDTO;
import com.example.foodordering.repositories.RevenueRepository;

@Service
public class RevenueService {

    private final RevenueRepository revenueRepository;

    @Autowired
    public RevenueService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public List<RevenueDTO> getMonthlyRevenue(int year) {
        List<Object[]> monthlyRevenueData = revenueRepository.getRevenueAmountsByMonthForYear(year);
        return convertToRevenueDTO(monthlyRevenueData);
    }

    public List<RevenueDTO> getWeeklyRevenue(int month, int year) {
        List<Object[]> weeklyRevenueData = revenueRepository.getRevenueAmountsByWeekForMonthAndYear(month, year);
        return convertToRevenueDTO(weeklyRevenueData);
    }

    private List<RevenueDTO> convertToRevenueDTO(List<Object[]> revenueData) {
        List<RevenueDTO> revenueDTOList = new ArrayList<>();

        for (Object[] data : revenueData) {
            RevenueDTO revenueDTO = new RevenueDTO();
            revenueDTO.setId((Integer) data[0]);
            revenueDTO.setAmount((BigDecimal) data[1]);

            revenueDTOList.add(revenueDTO);
        }

        return revenueDTOList;
    }
}