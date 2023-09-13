package com.example.foodordering.services;

import com.example.foodordering.DTO.OrderedDTO;
import com.example.foodordering.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

  public List<OrderedDTO> customerOrderList(Long tableId){
        return orderRepository.findByTableId(tableId);
    }
}
