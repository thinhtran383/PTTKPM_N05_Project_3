package com.example.foodordering.controller;

import com.example.foodordering.DTO.ResponseObject;
import com.example.foodordering.constant.TableStatus;
import com.example.foodordering.repositories.TableRepository;
import com.example.foodordering.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/table")
public class TableController {
    @Autowired // dependency injection
    TableRepository tableRepository;
    @Autowired
    TableService tableService;
    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllTable(@RequestParam(value = "filterByStatus", required = false) TableStatus tableStatus){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Query successfully", tableService.getAllAvailableTables(tableStatus))
        );
    }

    @PutMapping("/updateTableStatus-{id}")
    public ResponseEntity<ResponseObject> updateTableStatus(@PathVariable Long id){
        tableService.changeStatusTable(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ResponseObject("ok", "Query successfully","")
        );
    }


}
