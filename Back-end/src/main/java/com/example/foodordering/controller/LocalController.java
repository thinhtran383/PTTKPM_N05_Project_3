package com.example.foodordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class LocalController {
    @GetMapping("")
    public String helloF(){
        return "Hello Word";
    }
}
