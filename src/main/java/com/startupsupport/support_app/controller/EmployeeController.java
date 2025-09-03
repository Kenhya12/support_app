package com.startupsupport.support_app.controller;

import org.springframework.web.bind.annotation.RestController;
import com.startupsupport.support_app.service.EmployeeService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/employees") // Base path for all employee-related endpoints
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; // Assuming there's a service layer for business logic

    // GET obtener todos los empleados
    @GetMapping
    public ResponseEntity<List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // GET obtener empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    // POST crear un nuevo empleado
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(201).body(newEmployee); // 201 Created
    }

    // PUT actualizar un empleado existente
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee); // 200 OK
    }

    // DELETE eliminar un empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}
