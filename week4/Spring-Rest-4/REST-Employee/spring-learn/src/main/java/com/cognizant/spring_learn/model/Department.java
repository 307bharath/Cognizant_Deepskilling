package com.cognizant.spring_learn.model;

import jakarta.validation.constraints.*;

public class Department {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 30)
    private String name;

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
@Override
public String toString() {
    return "Department{" +
           "id=" + id +
           ", name='" + name + '\'' +
           '}';
}
}
