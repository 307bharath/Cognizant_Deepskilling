package com.cognizant.spring_learn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.Date;
import java.util.List;

public class Employee {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 30)
    private String name;

    @NotNull
    @Min(value = 0, message = "Salary must be zero or above")
    private Double salary;

    @NotNull
    private Boolean permanent;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @Valid
    private Department department;

    @Valid
    private List<Skill> skills;

    // Getters, Setters, toString
    public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Double getSalary() {
    return salary;
}

public void setSalary(Double salary) {
    this.salary = salary;
}

public Boolean getPermanent() {
    return permanent;
}

public void setPermanent(Boolean permanent) {
    this.permanent = permanent;
}

public Date getDateOfBirth() {
    return dateOfBirth;
}

public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
}

public Department getDepartment() {
    return department;
}

public void setDepartment(Department department) {
    this.department = department;
}

public List<Skill> getSkills() {
    return skills;
}

public void setSkills(List<Skill> skills) {
    this.skills = skills;
}
@Override
public String toString() {
    return "Employee{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", salary=" + salary +
           ", permanent=" + permanent +
           ", dateOfBirth=" + dateOfBirth +
           ", department=" + department +
           ", skills=" + skills +
           '}';
}

}