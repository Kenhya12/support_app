package com.startupsupport.support_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "request_status")
public class RequestStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusName; // Ejemplo: "Pendiente", "Atendida"

    public RequestStatus() {}
    public RequestStatus(String statusName) {
        this.statusName = statusName;
    }

    // Getters y Setters
}
