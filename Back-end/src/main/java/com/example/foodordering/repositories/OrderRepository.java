package com.example.foodordering.repositories;

import com.example.foodordering.entity.Order;
import com.example.foodordering.models.OrderedDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT new com.example.foodordering.models.OrderedDTO(r.tableId.id, m.name, o.quantity, m.price) FROM Order o " +
            "JOIN o.reservation r " +
            "JOIN o.menuItem m " +
            "WHERE r.tableId.id = :tableId")
    List<OrderedDTO> findByTableId(Long tableId);
}
