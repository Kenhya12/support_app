package com.startupsupport.support_app.repository;

import com.startupsupport.support_app.model.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportResquestRepository extends JpaRepository<RequestStatus, Long> {

    // Puedes agregar métodos personalizados de consulta si es necesario
} 