package com.startupsupport.support_app.repository;

import org.springframework.stereotype.Repository;
import com.startupsupport.support_app.Entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {
    
}
