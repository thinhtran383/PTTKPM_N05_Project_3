package com.example.foodordering.services;

import com.example.foodordering.entity.Employee;
import com.example.foodordering.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        // Mã hoá mật khẩu trước khi lưu vào cơ sở dữ liệu
        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        return employeeRepository.save(employee);
    }

    public boolean checkPassword(Employee employee, String rawPassword) {
        // So sánh mật khẩu nguyên bản với mật khẩu đã được mã hoá trong cơ sở dữ liệu
        return passwordEncoder.matches(rawPassword, employee.getPassword());
    }

    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }
}
