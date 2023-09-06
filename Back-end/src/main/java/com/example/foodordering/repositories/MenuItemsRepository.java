package com.example.foodordering.repositories;

import com.example.foodordering.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemsRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByName(String name);
    List<MenuItem>findMenuItemByName(String name);
}
