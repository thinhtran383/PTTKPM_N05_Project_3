package com.example.foodordering.controller;

import com.example.foodordering.models.MenuItem;
import com.example.foodordering.models.ResponseObject;
import com.example.foodordering.repositories.MenuItemsRepository;
import com.example.foodordering.services.MenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/menu")
public class MenuItemsController {
    @Autowired
    private MenuItemsRepository menuItemsRepository;

    @Autowired
    private MenuItemsService menuItemsService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllMenuItems(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query successfully", menuItemsRepository.findAll())
        );
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addNewItem(@RequestBody MenuItem menuItem){
        return menuItemsService.addNewItem(menuItem);
    }
}
