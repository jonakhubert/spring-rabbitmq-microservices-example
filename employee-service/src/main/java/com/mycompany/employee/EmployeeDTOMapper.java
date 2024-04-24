package com.mycompany.employee;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EmployeeDTOMapper implements Function<Employee, EmployeeDTO> {

    @Override
    public EmployeeDTO apply(Employee employee) {
        return new EmployeeDTO(employee.getFirstName(), employee.getLastName(), employee.getPosition());
    }
}
