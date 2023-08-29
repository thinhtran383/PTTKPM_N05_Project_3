package com.example.foodordering.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@ToString
@Data
public class ResponseObject { // resful api
    private String status;
    private String message;
    private Object data;
}
