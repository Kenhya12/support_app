package com.startupsupport.support_app.dto;

public class RequestStatusDTO {
    private Long id;
    private String status;

    public RequestStatusDTO() {}

    public RequestStatusDTO(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
