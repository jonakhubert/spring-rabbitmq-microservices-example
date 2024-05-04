package com.mycompany.employee;

import java.util.Date;

public record EmployeeDTO(
        String id,
        String firstName,
        String lastName,
        int age,
        String email,
        String position,
        Date addedDate
) {}
