package com.ty.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.ems.entity.Employee;
import com.ty.ems.entity.Payroll;

import java.util.List;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

    // Find all payroll records for a specific employee
    List<Payroll> findByEmployee(Employee employee);
}
