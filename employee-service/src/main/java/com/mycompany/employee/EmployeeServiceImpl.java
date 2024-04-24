package com.mycompany.employee;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDTOMapper employeeDTOMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeDTOMapper employeeDTOMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeDTOMapper = employeeDTOMapper;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeDTOMapper).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployee(String id) {
        return employeeRepository.findById(id).map(employeeDTOMapper)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<EmployeeDTO> getEmployeesPage(int pageSize, int pageNumber, String sortField, String sortDirection) {
        return null;
    }
}
