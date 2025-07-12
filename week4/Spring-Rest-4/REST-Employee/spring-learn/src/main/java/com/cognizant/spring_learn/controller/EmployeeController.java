package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PutMapping
    public void updateEmployee(@RequestBody @Valid Employee employee) {
        LOGGER.info("START updateEmployee");
        employeeService.updateEmployee(employee);
        LOGGER.info("END updateEmployee");
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        LOGGER.info("START deleteEmployee");
        employeeService.deleteEmployee(id);
        LOGGER.info("END deleteEmployee");
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}