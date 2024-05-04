package com.mycompany.employee;

public record EmployeeDTO(
        String id,
        String firstName,
        String lastName,
        int age,
        String email,
        String position
) {}
