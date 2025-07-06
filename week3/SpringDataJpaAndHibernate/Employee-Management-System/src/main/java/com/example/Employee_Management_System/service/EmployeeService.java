package com.example.Employee_Management_System.service;

import com.example.Employee_Management_System.entity.Employee;
import com.example.Employee_Management_System.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Batch save method (Hibernate batch insert support)
    public void saveAllEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

    // Optional: individual operations can also go here later
}
