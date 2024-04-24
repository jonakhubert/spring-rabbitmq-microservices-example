package com.mycompany.employee;

import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployee(String id);
    void saveEmployee(Employee employee);
    void deleteEmployee(String id);
    Page<EmployeeDTO> getEmployeesPage(int pageSize, int pageNumber, String sortField, String sortDirection);
}
