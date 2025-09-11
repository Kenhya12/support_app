package com.startupsupport.support_app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.startupsupport.support_app.Entity.EmployeeEntity;
import com.startupsupport.support_app.Entity.TechnicianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TechnicianRepository extends JpaRepository<TechnicianEntity, Long> {   
    
    // Buscar técnico por nombre
    TechnicianEntity findByName(String name);

    // Buscar técnico por especialidad (ej: "Networking")
    TechnicianEntity findBySpecialty(String specialty);
}
