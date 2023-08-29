package com.example.foodordering.controller;

import com.example.foodordering.models.ResponseObject;
import com.example.foodordering.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/table")
public class TableController {
    @Autowired
    TableRepository tableRepository;

    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllTable(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query successfully", tableRepository.findAll())
        );
    }
}
