package com.startupsupport.support_app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.startupsupport.support_app.Entity.EmployeeEntity;
import com.startupsupport.support_app.Entity.RequestStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RequestStatusRepository extends JpaRepository<RequestStatusEntity, Long> {
    
    // Buscar un estado por su nombre (ej: "Pending")
    RequestStatusEntity findByStatus(String status);
} 
