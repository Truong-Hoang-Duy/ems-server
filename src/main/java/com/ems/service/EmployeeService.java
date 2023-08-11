package com.ems.service;

import com.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Integer employeeId);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Integer employeeId, EmployeeDto updateEmployee);
    void deleteEmployee(Integer employeeId);
}
