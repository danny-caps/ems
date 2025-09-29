package com.ty.ems.entity;

import jakarta.persistence.*;

@Entity
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String month;        // e.g., "September 2025"
    private double salaryPaid;
    private double bonus;
    private double deductions;

    // Constructors
    public Payroll() {}

    public Payroll(Employee employee, String month, double salaryPaid, double bonus, double deductions) {
        this.employee = employee;
        this.month = month;
        this.salaryPaid = salaryPaid;
        this.bonus = bonus;
        this.deductions = deductions;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public double getSalaryPaid() { return salaryPaid; }
    public void setSalaryPaid(double salaryPaid) { this.salaryPaid = salaryPaid; }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    public double getDeductions() { return deductions; }
    public void setDeductions(double deductions) { this.deductions = deductions; }
}