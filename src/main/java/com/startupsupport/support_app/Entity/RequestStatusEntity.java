package com.startupsupport.support_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "request_status")
public class RequestStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusName; // Ejemplo: "Pendiente", "Atendida"

    public RequestStatusEntity() {}
    public RequestStatusEntity(String statusName) {
        this.statusName = statusName;
    }

    // Getters y Setters
}
