package com.startupsupport.support_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.startupsupport.support_app.repository.RequestRepository;
import com.startupsupport.support_app.Entity.RequestEntity;


@RestController
@RequestMapping("/api/requests") 
public class ResquestController {

    private final RequestRepository requestRepository;

    public ResquestController(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    // GET obtener todas las solicitudes
    @GetMapping
        public ResponseEntity<List<RequestEntity>> getAllRequests() {
        List<RequestEntity> requests = requestRepository.findAll();
        return ResponseEntity.ok(requests); // 200 OK
    }

    // GET obtener solicitud por ID
    @GetMapping("/{id}")
        public ResponseEntity<RequestEntity> getRequestById(@PathVariable Long id) {
        return requestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST crear una nueva solicitud
    @PostMapping
        public ResponseEntity<RequestEntity> createRequest(@RequestBody RequestEntity request) {
        RequestEntity savedRequest = requestRepository.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRequest); // 201 Created
    }

    // DELETE eliminar una solicitud
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        if (!requestRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        requestRepository.deleteById(id);
                return ResponseEntity.noContent().build(); // 204 No Content
    }

}
