package com.eduardoguedes.trackhours.employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Tag(name = "Company")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "List all Employees", method = "GET")
    @GetMapping
    public List<EmployeeEntity> listAllEmployees() {
        return employeeService.listAllEmployees();
    }

    @PostMapping
    public void createAndEditEmployee(@RequestBody EmployeeEntity employeeEntity) {
        employeeService.createAndEditEmployee(employeeEntity);
    }

    @DeleteMapping("/{eplId}")
    public void deleteEmployee(@PathVariable int eplId) {
        employeeService.deleteEmployee(eplId);
    }
}
