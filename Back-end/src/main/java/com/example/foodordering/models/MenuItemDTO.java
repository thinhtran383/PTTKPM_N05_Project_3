package com.example.foodordering.models;

import com.example.foodordering.entity.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDTO { // Data tranfer object
    private Long id;
    private String name;
    private BigDecimal price;
    private int quantityRemaining;
    private String imageUrl; // Đường dẫn tới hình ảnh
}
