package com.startupsupport.support_app.mapper;

import com.startupsupport.support_app.Entity.EmployeeEntity;
import com.startupsupport.support_app.dto.EmployeeDTO;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(EmployeeEntity entity) {
        return new EmployeeDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getDepartment());
    }

    public static EmployeeEntity toEntity(EmployeeDTO dto) {
        return new EmployeeEntity(dto.getName(), dto.getEmail(), dto.getDepartment());
    }
}