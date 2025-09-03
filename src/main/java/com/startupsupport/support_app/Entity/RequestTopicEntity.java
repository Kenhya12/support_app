package com.startupsupport.support_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "request_topic")
public class RequestTopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topic_name", nullable = false, unique = true)
    private String topic; // Ejemplo: "Hardware", "Software"

    public RequestTopicEntity() {
    }

    public RequestTopicEntity(String topicName) {
        this.topicName = topicName;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}