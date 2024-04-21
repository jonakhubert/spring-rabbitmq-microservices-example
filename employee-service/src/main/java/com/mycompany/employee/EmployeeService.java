package com.mycompany.employee;

import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployee(String id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(String id);
    Page<Employee> getEmployeesPage(int pageSize, int pageNumber, String sortField, String sortDirection);
}
