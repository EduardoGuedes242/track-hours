package com.eduardoguedes.trackhours.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

  List<EmployeeEntity> findByTenantId(Integer tenantId);
  Optional<EmployeeEntity> findById(Integer id);

}
