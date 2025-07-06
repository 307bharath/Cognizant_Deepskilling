package com.example.Employee_Management_System.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.example.Employee_Management_System.audit.Auditable;
import jakarta.persistence.*;
import lombok.*;

@NamedQuery(name = "Employee.findByDepartmentName",
        query = "SELECT e FROM Employee e WHERE e.department.name = ?1")
@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.DynamicUpdate
public class Employee extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

   @ManyToOne
@JoinColumn(name = "department_id")
@JsonBackReference
private Department department;

}
