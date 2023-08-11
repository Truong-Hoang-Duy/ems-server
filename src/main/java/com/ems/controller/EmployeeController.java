package com.ems.controller;

import com.ems.dto.EmployeeDto;
import com.ems.service.EmployeeService;
import com.ems.utils.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeDto employeeDto) {
        try {
            EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
            return ResponseHandler.response("Successfully added data!", HttpStatus.CREATED, savedEmployee);
        } catch (Exception e) {
            return ResponseHandler.response("Email already exists", HttpStatus.CONFLICT, null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") Integer employeeId) {
        try {
            EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
            return ResponseHandler.response(HttpStatus.OK, employeeDto);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.NOT_FOUND, null);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getEmployee() {
        try {
            List<EmployeeDto> employeeDto = employeeService.getAllEmployee();
            return ResponseHandler.response(HttpStatus.OK, employeeDto);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.NOT_FOUND, null);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") Integer employeeId, @RequestBody EmployeeDto updateEmployee) {
        try {
            EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updateEmployee);
            return ResponseHandler.response(HttpStatus.OK, employeeDto);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.NOT_FOUND, null);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Integer employeeId) {
        try {
            employeeService.deleteEmployee(employeeId);
            return ResponseHandler.response("Employee deleted successfully!" ,HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.response(e.getMessage(), HttpStatus.NOT_FOUND, null);
        }
    }
}
