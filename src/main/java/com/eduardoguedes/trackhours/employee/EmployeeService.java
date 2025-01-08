package com.eduardoguedes.trackhours.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> listAllEmployees(){
        return employeeRepository.findAll();
    }

}
