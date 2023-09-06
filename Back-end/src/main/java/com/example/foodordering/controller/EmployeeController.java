package com.example.foodordering.controller;

import com.example.foodordering.entity.Employee;
import com.example.foodordering.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        if (savedEmployee != null) {
            return new ResponseEntity<>("Employee registered successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Employee registration failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginEmployee(@RequestBody Employee request) {
        Employee foundEmployee = employeeService.findByUsername(request.getUsername());
        if (foundEmployee != null && employeeService.checkPassword(foundEmployee, request.getPassword())) {
            return new ResponseEntity<>("Employee login successful!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee login failed.", HttpStatus.UNAUTHORIZED);
        }
    }


}
