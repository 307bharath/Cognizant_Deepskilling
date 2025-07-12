package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.exception.EmployeeNotFoundException;
import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.model.Department;
import com.cognizant.spring_learn.model.Skill;

import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeDao {

    private static final List<Employee> employeeList = new ArrayList<>();

    static {
        try {
            Employee emp = new Employee();
            emp.setId(1);
            emp.setName("Test User");
            emp.setSalary(50000.0);
            emp.setPermanent(true);
            emp.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1990"));

            Department dept = new Department();
            dept.setId(101);
            dept.setName("Engineering");
            emp.setDepartment(dept);

            List<Skill> skills = new ArrayList<>();
            Skill skill1 = new Skill();
            skill1.setId(201);
            skill1.setName("Java");
            skills.add(skill1);

            emp.setSkills(skills);

            employeeList.add(emp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee updated) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (Objects.equals(employeeList.get(i).getId(), updated.getId())) {
                employeeList.set(i, updated);
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + updated.getId() + " not found.");
    }

    public void deleteEmployee(int id) {
        boolean removed = employeeList.removeIf(emp -> emp.getId() == id);
        if (!removed) throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}