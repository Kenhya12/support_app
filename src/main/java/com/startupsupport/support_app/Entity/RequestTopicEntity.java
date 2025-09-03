package com.startupsupport.support_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "request_topic")
public class RequestTopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topicName; // Ejemplo: "Hardware", "Software"

    public RequestTopicEntity() {}
    public RequestTopicEntity(String topicName) {
        this.topicName = topicName;
    }

    // Getters y Setters
}