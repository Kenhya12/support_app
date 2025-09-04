package com.startupsupport.support_app.service;

import com.startupsupport.support_app.Entity.EmployeeEntity;
import com.startupsupport.support_app.dto.EmployeeDTO;
import com.startupsupport.support_app.mapper.EmployeeMapper;
import com.startupsupport.support_app.repository.EmployeeRepository;
import com.startupsupport.support_app.implementation.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private EmployeeEntity employeeEntity;
    private EmployeeDTO employeeDTO;

    @BeforeEach
    void setUp() {
        employeeEntity = new EmployeeEntity("Paula", "paula@email.com", "IT");
        employeeEntity.setId(1L);
        employeeDTO = EmployeeMapper.toDTO(employeeEntity);
    }

    @Test
    void testCreateEmployee() {
        when(employeeRepository.save(any(EmployeeEntity.class))).thenReturn(employeeEntity);

        EmployeeDTO result = employeeService.createEmployee(employeeDTO);

        assertEquals(employeeDTO.getName(), result.getName());
        verify(employeeRepository, times(1)).save(any(EmployeeEntity.class));
    }

    @Test
    void testGetAllEmployees() {
        when(employeeRepository.findAll()).thenReturn(List.of(employeeEntity));

        List<EmployeeDTO> employees = employeeService.getAllEmployees();

        assertEquals(1, employees.size());
        assertEquals("Paula", employees.get(0).getName());
    }
}
