package com.example.Employee_Management_System.repository;

import com.example.Employee_Management_System.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import com.example.Employee_Management_System.projection.EmployeeNameEmailView;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
      // Derived query method
    List<Employee> findByNameContainingIgnoreCase(String name);
    List<EmployeeNameEmailView> findAllBy();


    // Custom JPQL query
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email") String email);

    // Named Query (see entity below)
    List<Employee> findByDepartmentName(String name);
}
