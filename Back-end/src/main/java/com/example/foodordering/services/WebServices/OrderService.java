package com.example.foodordering.services.WebServices;

import com.example.foodordering.DTO.OrderedDTO;
import com.example.foodordering.entity.Order;
import com.example.foodordering.entity.Reservation;
import com.example.foodordering.entity.Table;
import com.example.foodordering.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderedDTO> customerOrderList(Long tableId){
        return orderRepository.findByTableId(tableId);
  }

    public List<Order> getOrderByTableId(Long tableId){
//        System.out.println(orderRepository.findAllByReservationId(4L));
//        return orderRepository.findReservationIDsByTableID(tableId);
        return orderRepository.findByReservation_Id(tableId);
    }

    public void updateQuantity(Long menuId, Long quantity){
        List<Order> orderList = getOrderByTableId(4L);

        Order targetOrder = orderList.stream()
                .filter(order -> order.getMenuItem().getId().equals(menuId))
                .findFirst()
                .orElse(null);

        if(targetOrder != null){
           targetOrder.setQuantity(3);
           orderRepository.save(targetOrder);
        }
    }
}
