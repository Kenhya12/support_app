package com.startupsupport.support_app.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request")
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private TechnicianEntity technician;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private RequestStatusEntity status;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private RequestTopicEntity topic;

    private String problemDescription; // Ejemplo: "No puedo acceder al correo"
    private LocalDateTime createdAt;
    private LocalDateTime assignedAt;
    private LocalDateTime resolvedAt;
    private LocalDateTime lastEditedAt;

    public RequestEntity() {}

    // Constructor con campos esenciales, getters y setters
}