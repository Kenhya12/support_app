package com.startupsupport.support_app.repository;

import org.springframework.stereotype.Repository;
import com.startupsupport.support_app.Entity.TechnicianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TechnicianRepository extends JpaRepository<TechnicianEntity, Long> {   
    
}
