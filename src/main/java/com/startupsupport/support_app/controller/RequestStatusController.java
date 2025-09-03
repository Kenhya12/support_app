package com.startupsupport.support_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.startupsupport.support_app.model.RequestStatus;
import com.startupsupport.support_app.repository.RequestStatusRepository;
import javax.validation.Valid;


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
    public ResponseEntity<List<RequestStatus>> getAllRequestStatuses() {
        return ResponseEntity.ok(requestStatusRepository.findAll());
    }

    // POST crear un nuevo estado de solicitud
    @PostMapping
    public ResponseEntity<RequestStatus> createRequestStatus(@Valid @RequestBody RequestStatus requestStatus) {
        RequestStatus savedRequestStatus = requestStatusRepository.save(requestStatus);
        return ResponseEntity.ok(HttpStatus.CREATED).body(savedRequestStatus);
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

