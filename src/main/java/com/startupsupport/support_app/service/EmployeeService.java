package com.startupsupport.support_app.service;

import com.startupsupport.support_app.Entity.EmployeeEntity;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeEntity createEmployee(EmployeeEntity employee);

    List<EmployeeEntity> getAllEmployees();

    Optional<EmployeeEntity> getEmployeeById(Long id);

    EmployeeEntity updateEmployee(Long id, EmployeeEntity employee);

    void deleteEmployee(Long id);

    EmployeeEntity getEmployeeByEmail(String email);
}
