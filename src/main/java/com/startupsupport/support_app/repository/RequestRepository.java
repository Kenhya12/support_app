package com.startupsupport.support_app.repository;

import org.springframework.stereotype.Repository;

import com.startupsupport.support_app.Entity.EmployeeEntity;
import com.startupsupport.support_app.Entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.startupsupport.support_app.Entity.EmployeeEntity;
import com.startupsupport.support_app.Entity.RequestStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {
   // Buscar todas las solicitudes de un empleado
    List<RequestEntity> findByEmployee(EmployeeEntity employee);

    // Buscar todas las solicitudes por estado (ej: Pending, Resolved)
    List<RequestEntity> findByStatus(RequestStatusEntity status);

    // Buscar solicitudes por técnico asignado
    List<RequestEntity> findByTechnicianId(Long technicianId);

    // Ordenar todas las solicitudes por fecha de creación ASC
    List<RequestEntity> findAllByOrderByCreatedAtAsc(); 
}
