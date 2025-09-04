package com.startupsupport.support_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startupsupport.support_app.Entity.TechnicianEntity;
import com.startupsupport.support_app.repository.TechnicianRepository;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/technicans")
public class TechnicianController {
    
    private final TechnicianRepository technicianRepository;

    public TechnicianController(@Autowired TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    // GET Buscar un técnico por id
    @RequestMapping("/{id}")
    public ResponseEntity<TechnicianEntity> getTechnicanById(@PathVariable Long id) {
        return technicianRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // POST Crear un nuevo técnico
    @PostMapping
    public ResponseEntity<TechnicianEntity> createTechnician(@RequestBody TechnicianEntity technician) {
        TechnicianEntity savedTech = technicianRepository.save(technician);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTech);
    }   

    // PUT Actualizar un técnico por id
    @PutMapping("/{id}")
        public ResponseEntity<TechnicianEntity> updateTechnician(@PathVariable Long id, @RequestBody TechnicianEntity technicianDetails) {
        return technicianRepository.findById(id)
                .map(technician -> {
                    technician.setName(technicianDetails.getName());
                    technician.setEmail(technicianDetails.getEmail());
                    technician.setSpecialty(technicianDetails.getSpecialty());
                    TechnicianEntity updatedTech = technicianRepository.save(technician);
                    return ResponseEntity.ok().body(updatedTech);
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    // DELETE Eliminar un técnico por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnican(@PathVariable Long id ) {
        if (!technicianRepository.existsById(id)) {
            return ResponseEntity.noContent().build();
        } 
            technicianRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

}
