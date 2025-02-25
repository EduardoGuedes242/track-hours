package com.eduardoguedes.trackhours.employee;

import com.eduardoguedes.trackhours.infra.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> listAllEmployees(){
        System.out.println(jwtTokenUtil.getTenantIdFromToken());
        return employeeRepository.findByTenantId(jwtTokenUtil.getTenantIdFromToken());
    }

    public void createAndEditEmployee(EmployeeEntity employeeEntity) {
        employeeEntity.setTenantId(jwtTokenUtil.getTenantIdFromToken());
        employeeRepository.save(employeeEntity);
    }

    public void deleteEmployee(int eplId) {
        employeeRepository.deleteById(eplId);
    }

}
