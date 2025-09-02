package com.startupsupport.support_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "request_topic")
public class RequestTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topicName; // Ejemplo: "Hardware", "Software"

    public RequestTopic() {}
    public RequestTopic(String topicName) {
        this.topicName = topicName;
    }

    // Getters y Setters
}