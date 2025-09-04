package com.startupsupport.support_app.dto;

public class RequestTopicDTO {
    private Long id;
    private String topic;

    public RequestTopicDTO() {}

    public RequestTopicDTO(Long id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }
}
