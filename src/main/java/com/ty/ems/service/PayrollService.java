package com.ty.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ems.entity.Employee;
import com.ty.ems.entity.Payroll;
import com.ty.ems.repository.EmployeeRepository;
import com.ty.ems.repository.PayrollRepository;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Add a payroll entry
    public Payroll addPayroll(Long employeeId, String month, double salaryPaid, double bonus, double deductions) {
        Optional<Employee> empOpt = employeeRepository.findById(employeeId);
        if (empOpt.isPresent()) {
            Payroll payroll = new Payroll();
            payroll.setEmployee(empOpt.get());
            payroll.setMonth(month);
            payroll.setSalaryPaid(salaryPaid);
            payroll.setBonus(bonus);
            payroll.setDeductions(deductions);
            return payrollRepository.save(payroll);
        }
        return null;
    }

    // Get payroll by employee
    public List<Payroll> getPayrollByEmployee(Employee employee) {
        return payrollRepository.findByEmployee(employee);
    }

    // Get all payroll records
    public List<Payroll> getAllPayroll() {
        return payrollRepository.findAll();
    }
}
