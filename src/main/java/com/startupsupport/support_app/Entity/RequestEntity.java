package com.startupsupport.support_app.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "request")
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime createdAt;
    /* private LocalDateTime assignedAt;
    private LocalDateTime resolvedAt;
    private LocalDateTime lastEditedAt;*/

    // Relaciones con otras entidades

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private RequestStatusEntity status;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private RequestTopicEntity topic;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private TechnicianEntity technician;

    public RequestEntity() {
        this.createdAt = LocalDateTime.now();
}  

    public RequestEntity(String description, LocalDateTime createdAt, EmployeeEntity employee, RequestStatusEntity status, RequestTopicEntity topic) {
        this.description = description;
        this.createdAt = createdAt;
        this.employee = employee;
        this.status = status;
        this.topic = topic;
    }


    // Constructor con campos esenciales, getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public RequestTopicEntity getTopic() {
        return topic;
    }

    public void setTopic(RequestTopicEntity topic) {
        this.topic = topic;
    }

	public void setStatus(RequestStatusEntity pendingStatus) {
		this.status = pendingStatus;
	}

	public void setCreatedAt(LocalDateTime now) {
		this.createdAt = now;
	}

	public void setUpdatedAt(LocalDateTime now) {
        this.createdAt = now;
	}

	public void setTechnician(Object technician2) {
        this.technician = (TechnicianEntity) technician2;
	}

	public RequestStatusEntity getStatus() {
        return status;
	}

	public void setResolvedAt(LocalDateTime now) {
        this.createdAt = now;
	}

	public Object getTechnician() {
        return technician;
	}
}