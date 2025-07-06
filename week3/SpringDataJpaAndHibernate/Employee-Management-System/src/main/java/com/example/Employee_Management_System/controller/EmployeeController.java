package com.example.Employee_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import com.example.Employee_Management_System.entity.Employee;
import com.example.Employee_Management_System.projection.EmployeeNameEmailView;
import com.example.Employee_Management_System.service.EmployeeService;
import com.example.Employee_Management_System.repository.EmployeeRepository;


import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/page")
    public Page<Employee> getEmployeesPage(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "name") String sortBy) {
        return employeeRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping("/projection")
    public List<EmployeeNameEmailView> getEmployeeNameEmail() {
        return employeeRepository.findAllBy();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
      @PostMapping("/employees/batch")
public ResponseEntity<?> saveEmployees(@RequestBody List<Employee> employees) {
    employeeService.saveAllEmployees(employees);
    return ResponseEntity.ok("Batch inserted successfully!");
}

    @PostMapping("/batch")
    public String saveAllEmployees(@RequestBody List<Employee> employees) {
        employeeService.saveAllEmployees(employees);
        return "Batch save successful!";
    }


    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updated) {
        return employeeRepository.findById(id).map(e -> {
            e.setName(updated.getName());
            e.setEmail(updated.getEmail());
            e.setDepartment(updated.getDepartment());
            return employeeRepository.save(e);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
