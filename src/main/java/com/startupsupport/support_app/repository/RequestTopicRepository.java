package com.startupsupport.support_app.repository;

import org.springframework.stereotype.Repository;
import com.startupsupport.support_app.Entity.RequestTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RequestTopicRepository extends JpaRepository<RequestTopicEntity, Long> {
    
    // Buscar un tema por su nombre (ej: "Hardware")
    RequestTopicEntity findByTopic(String topic);
}
