package com.startupsupport.support_app.implementation;

import com.startupsupport.support_app.Entity.EmployeeEntity;
import com.startupsupport.support_app.repository.EmployeeRepository;
import com.startupsupport.support_app.service.EmployeeService;
import com.startupsupport.support_app.dto.EmployeeDTO;
import org.springframework.stereotype.Service;
import com.startupsupport.support_app.mapper.EmployeeMapper;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        EmployeeEntity entity = EmployeeMapper.toEntity(dto);
        EmployeeEntity saved = employeeRepository.save(entity);
        return EmployeeMapper.toDTO(saved);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(EmployeeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        return employeeRepository.findById(id).map(entity -> {
            entity.setName(dto.getName());
            entity.setEmail(dto.getEmail());
            entity.setDepartment(dto.getDepartment());
            return EmployeeMapper.toDTO(employeeRepository.save(entity));
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO getEmployeeByEmail(String email) {
        EmployeeEntity entity = employeeRepository.findByEmail(email);
        return entity != null ? EmployeeMapper.toDTO(entity) : null;
    }
}