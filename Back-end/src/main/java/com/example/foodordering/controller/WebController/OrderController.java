package com.example.foodordering.controller.WebController;

import com.example.foodordering.DTO.ResponseObject;
import com.example.foodordering.entity.Table;
import com.example.foodordering.services.WebServices.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> getAllOrdered(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query successfully",orderService.customerOrderList(id))
        );
    }

    @PutMapping("/update/{id}")
    ResponseEntity<ResponseObject> updateQuantityOrder(@PathVariable Long id){
        orderService.updateQuantity(1L,1L);
        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject("ok", "Update success", orderService.getOrderByTableId(id))
                new ResponseObject("ok", "Update success", "")
        );
    }
}
