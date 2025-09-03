package com.startupsupport.support_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "technician")
public class TechnicianEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String specialty;

    public TechnicianEntity() {}
    public TechnicianEntity(String name, String email, String specialty) {
        this.name = name;
        this.email = email;
        this.specialty = specialty;
    }

    // Getters y Setters
}