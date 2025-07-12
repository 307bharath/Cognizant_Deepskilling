package com.example.spring_learn.dao;

import com.example.spring_learn.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentDao {
    private static List<Department> DEPARTMENT_LIST;

    @Autowired
    public DepartmentDao(@Qualifier("departmentList") List<Department> departmentList) {
        DEPARTMENT_LIST = departmentList;
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}