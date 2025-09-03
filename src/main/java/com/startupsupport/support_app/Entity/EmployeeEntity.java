package com.startupsupport.support_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String department;

    public EmployeeEntity() {}

    public EmployeeEntity(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    // Getters y Setters
}