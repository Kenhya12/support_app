package com.startupsupport.support_app.repository;

import com.startupsupport.support_app.model.SupportResquest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportResquestRepository extends JpaRepository<SupportResquest, Long> {

    // Puedes agregar métodos personalizados de consulta si es necesario
} 