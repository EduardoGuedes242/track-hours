package com.eduardoguedes.trackhours.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeEntity> listAllEmployees() {
        return employeeService.listAllEmployees();
    }

    @PostMapping
    public void createAndEditEmployee(@RequestBody EmployeeEntity employeeEntity) {
        employeeService.createAndEditEmployee(employeeEntity);
    }
}
