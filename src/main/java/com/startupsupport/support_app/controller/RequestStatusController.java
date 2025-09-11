package com.startupsupport.support_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.startupsupport.support_app.repository.RequestStatusRepository;
import com.startupsupport.support_app.Entity.RequestStatusEntity;


@RestController
@RequestMapping("/api/request-status")
public class RequestStatusController {

    private final RequestStatusRepository requestStatusRepository;

    @Autowired
    public RequestStatusController(RequestStatusRepository requestStatusRepository) {
        this.requestStatusRepository = requestStatusRepository;
    }

    // GET listar todos los estados de solicitud
    @GetMapping
    public ResponseEntity<List<RequestStatusEntity>> getAllRequestStatuses() {
        return ResponseEntity.ok(requestStatusRepository.findAll());
    }

    // POST crear un nuevo estado de solicitud
    @PostMapping
                public ResponseEntity<RequestStatusEntity> createRequestStatus(@RequestBody RequestStatusEntity requestStatus) {
        RequestStatusEntity savedRequestStatus = requestStatusRepository.save(requestStatus);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRequestStatus);
    }

    // DELETE eliminar un estado de solicitud por ID
@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequestStatus(@PathVariable Long id) {
        if (!requestStatusRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        requestStatusRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}    

