package com.startupsupport.support_app.implementation;

import com.startupsupport.support_app.Entity.EmployeeEntity;
import com.startupsupport.support_app.dto.EmployeeDTO;
import com.startupsupport.support_app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import com.startupsupport.support_app.service.EmployeeService;


import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
    EmployeeEntity employee = new EmployeeEntity(
        employeeDTO.getName(),
        employeeDTO.getEmail(),
        employeeDTO.getDepartment()
    );
    EmployeeEntity saved = employeeRepository.save(employee);
    return new EmployeeDTO(saved.getId(), saved.getName(), saved.getEmail(), saved.getDepartment());
}

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
    return employee.map(emp -> new EmployeeDTO(emp.getId(), emp.getName(), emp.getEmail(), emp.getDepartment()))
            .orElse(null);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(emp -> new EmployeeDTO(emp.getId(), emp.getName(), emp.getEmail(), emp.getDepartment()))
                .collect(Collectors.toList());
    }


    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(employeeDTO.getName());
            emp.setEmail(employeeDTO.getEmail());
            emp.setDepartment(employeeDTO.getDepartment());
            EmployeeEntity updated = employeeRepository.save(emp);
            return new EmployeeDTO(updated.getId(), updated.getName(), updated.getEmail(), updated.getDepartment());
        }).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO getEmployeeByEmail(String email) {
        EmployeeEntity employee = employeeRepository.findByEmail(email);
        if (employee != null) {
            return new EmployeeDTO(employee.getId(), employee.getName(), employee.getEmail(), employee.getDepartment());
        } else {
            return null;
        }
    }
}
