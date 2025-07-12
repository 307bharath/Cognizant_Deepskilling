package com.example.spring_learn.dao;

import com.example.spring_learn.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao {
    private static List<Employee> EMPLOYEE_LIST;

    @Autowired
    public EmployeeDao(@Qualifier("employeeList") List<Employee> employeeList) {
        EMPLOYEE_LIST = employeeList;
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}