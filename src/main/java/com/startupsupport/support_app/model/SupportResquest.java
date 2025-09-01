package com.startupsupport.support_app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "support_requests")
public class SupportResquest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resqueterName;

    private LocalDateTime resquestDate;

    private String topic;

    @Column(length = 2000)
    private String description;

    private String status;

    private String attendedBy;

    private LocalDateTime attendedDate;

    private LocalDateTime lastEditedDate;

    // Constructor vacío
    public SupportResquest() {
    }

    // Getters y Setters
    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getResqueterName() {
        return resqueterName;
    }

    public void setResqueterName(String resqueterName) {
        this.resqueterName = resqueterName;
    }

    public LocalDateTime getResquestDate() {
        return resquestDate;
    }

    public void setResquestDate(LocalDateTime resquestDate) {
        this.resquestDate = resquestDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttendedBy() {
        return attendedBy;
    }

    public void setAttendedBy(String attendedBy) {
        this.attendedBy = attendedBy;
    }

    public LocalDateTime getAttendedDate() {
        return attendedDate;
    }

    public void setAttendedDate(LocalDateTime attendedDate) {
        this.attendedDate = attendedDate;
    }

    public LocalDateTime getLastEditedDate() {
        return lastEditedDate;
    }

    public void setLastEditedDate(LocalDateTime lastEditedDate) {
        this.lastEditedDate = lastEditedDate;
    }

}
