package com.mycompany.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee((employee));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") String id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") String id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
