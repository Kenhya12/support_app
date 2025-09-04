package com.startupsupport.support_app.service;


import com.startupsupport.support_app.Entity.RequestEntity;
import com.startupsupport.support_app.Entity.RequestStatusEntity;
import com.startupsupport.support_app.repository.RequestRepository;
import com.startupsupport.support_app.repository.RequestStatusRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequestService {

    private final RequestRepository requestRepository;
    private final RequestStatusRepository requestStatusRepository;

    public RequestService(RequestRepository requestRepository, RequestStatusRepository requestStatusRepository) {
        this.requestRepository = requestRepository;
        this.requestStatusRepository = requestStatusRepository;
    }

    // Crear una nueva solicitud
    public RequestEntity createRequest(RequestEntity request) {
        // Establecer el estado inicial de la solicitud
        RequestStatusEntity pendingStatus = requestStatusRepository.findByStatus("Pending");
        request.setStatus(pendingStatus);
        request.setCreatedAt(LocalDateTime.now());
        return requestRepository.save(request);
    }

    // Obtener todas las solicitudes
    public List<RequestEntity> getAllRequests() {
        return requestRepository.findAllByOrderByCreatedAtAsc();
    }

    // Actualizar solicitud
    public RequestEntity updateRequest(Long id, RequestEntity updatedRequest) {
        return requestRepository.findById(id).map(request -> {
            request.setDescription(updatedRequest.getDescription());
            request.setUpdatedAt(LocalDateTime.now());
            request.setTechnician(updatedRequest.getTechnician());
            request.setStatus(updatedRequest.getStatus());
            request.setTopic(updatedRequest.getTopic());
            return requestRepository.save(request);
        }).orElseThrow(() -> new RuntimeException("Request not found with id " + id));
    }

    // Marcar como resuelta
    public RequestEntity markAsResolved(Long id) {
        return requestRepository.findById(id).map(request -> {
            request.setResolvedAt(LocalDateTime.now());
            request.setStatus(requestStatusRepository.findByStatus("Resolved"));
            return requestRepository.save(request);
        }).orElseThrow(() -> new RuntimeException("Request not found with id " + id));
    }

    // Eliminar (solo si está resuelta)
    public void deleteRequest(Long id) {
        requestRepository.findById(id).ifPresent(request -> {
            if ("Resolved".equals(request.getStatus().getStatus())) {
                requestRepository.deleteById(id);
            } else {
                throw new RuntimeException("Cannot delete a request that is not resolved");
            }
        });
    }
}