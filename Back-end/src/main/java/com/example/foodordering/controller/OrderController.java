package com.example.foodordering.controller;

import com.example.foodordering.models.ResponseObject;
import com.example.foodordering.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
