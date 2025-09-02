package com.startupsupport.support_app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private RequestStatus status;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private RequestTopic topic;

    private String problemDescription; // Ejemplo: "No puedo acceder al correo"
    private LocalDateTime createdAt;
    private LocalDateTime assignedAt;
    private LocalDateTime resolvedAt;
    private LocalDateTime lastEditedAt;

    public Request() {}

    // Constructor con campos esenciales, getters y setters
}