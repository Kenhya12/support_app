package com.startupsupport.support_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.startupsupport.support_app.model.Request;
import com.startupsupport.support_app.repository.RequestRepository;

@RestController
@RequestMapping("/api/requests") // Base path for all request-related endpoints
public class ResquestController {

    private final RequestRepository requestRepository;

    public ResquestController(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    // GET obtener todas las solicitudes
    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests() {
        return ResponseEntity.ok(requestRepository.findAll());
    }

    // GET obtener solicitud por ID
    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable Long id) {
        return ResquestRepository.findById(id
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()));
    }

    // POST crear una nueva solicitud
    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody Request request) {
        Request saveRequest = requestRepository.save(request);
        return ResponseEntity.status(201).body(savedRequest); // 201 Created
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
