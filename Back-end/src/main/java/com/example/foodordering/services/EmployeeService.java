package com.example.foodordering.services;

import com.example.foodordering.constant.EmployeeRole;
import com.example.foodordering.entity.Employee;
import com.example.foodordering.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Employee saveEmployee(Employee employee) {
        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        return employeeRepository.save(employee);
    }

    public boolean checkPassword(Employee employee, String rawPassword) {
        return passwordEncoder.matches(rawPassword, employee.getPassword());
    }

    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    public EmployeeRole findRoleByUsername(String username){
        return employeeRepository.findRoleByUsername(username);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findByRole(EmployeeRole.Employee);
    }
}
