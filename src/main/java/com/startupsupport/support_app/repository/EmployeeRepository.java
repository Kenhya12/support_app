package com.startupsupport.support_app.repository;

import org.springframework.stereotype.Repository;
import com.startupsupport.support_app.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    
}
