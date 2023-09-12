package com.example.foodordering.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class OrderedDTO {
    private Long tableID;
    private String name;
    private int quantity;
    private BigDecimal price;
    private BigDecimal total;

    public OrderedDTO(Long tableID, String name, int quantity, BigDecimal price) {
        this.tableID = tableID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = price.multiply(BigDecimal.valueOf(quantity));
    }
}
