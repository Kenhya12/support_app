package com.startupsupport.support_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "request_status")
public class RequestStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String status; // Ejemplo: "Pendiente", "Atendida"

    public RequestStatusEntity() {
    }

    public RequestStatusEntity(String status) {
        this.status = status;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
