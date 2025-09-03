package com.startupsupport.support_app.repository;

import org.springframework.stereotype.Repository;
import com.startupsupport.support_app.Entity.RequestStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RequestStatusRepository extends JpaRepository<RequestStatusEntity, Long> {

} 
