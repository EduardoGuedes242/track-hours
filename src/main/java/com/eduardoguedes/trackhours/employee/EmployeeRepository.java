package com.eduardoguedes.trackhours.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

  List<EmployeeEntity> findByTenantId(Integer tenantId);

}
