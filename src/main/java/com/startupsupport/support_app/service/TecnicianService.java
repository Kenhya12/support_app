package com.startupsupport.support_app.service;

import com.startupsupport.support_app.Entity.TechnicianEntity;
import java.util.List;
import java.util.Optional;

public interface TecnicianService {
    TechnicianEntity createTechnician(TechnicianEntity technician);

    List<TechnicianEntity> getAllTechnicians();

    Optional<TechnicianEntity> getTechnicianById(Long id);

    TechnicianEntity updateTechnician(Long id, TechnicianEntity technician);

    void deleteTechnician(Long id);

    TechnicianEntity getTechnicianByName(String name);

    TechnicianEntity getTechnicianBySpecialty(String specialty);
}
