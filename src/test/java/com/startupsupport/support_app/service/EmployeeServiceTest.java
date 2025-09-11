package com.startupsupport.support_app.service;

import com.startupsupport.support_app.Entity.EmployeeEntity;
import com.startupsupport.support_app.dto.EmployeeDTO;
import com.startupsupport.support_app.repository.EmployeeRepository;

import com.startupsupport.support_app.implementation.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService; // tu implementación del servicio

    
    private EmployeeDTO employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new EmployeeDTO("Paula", "paula@example.com", "IT");
    }

    @Test
    void testCreateEmployee() {
        when(employeeRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        EmployeeDTO saved = employeeService.createEmployee(employee);

        assertNotNull(saved);
        assertEquals("Paula", saved.getName());
        verify(employeeRepository, times(1)).save(any());
    }

    @Test
    void testGetEmployeeById() {
        EmployeeEntity mockEntity = new EmployeeEntity("Paula", "paula@example.com", "IT");
        mockEntity.setId(1L);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(mockEntity));

        EmployeeDTO found = employeeService.getEmployeeById(1L);

        assertNotNull(found);
        assertEquals("Paula", found.getName());
        verify(employeeRepository, times(1)).findById(1L);
    }
}
