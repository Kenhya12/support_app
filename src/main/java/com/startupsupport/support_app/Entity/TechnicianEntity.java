package com.startupsupport.support_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "technician")
public class TechnicianEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "specialty", nullable = false)
    private String specialty;

    public TechnicianEntity() {}
    public TechnicianEntity(String name, String email, String specialty) {
        this.name = name;
        this.email = email;
        this.specialty = specialty;
    }

    // Getters y Setters
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}