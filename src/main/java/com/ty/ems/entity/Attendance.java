package com.ty.ems.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate date;
    private String status; // PRESENT, ABSENT, LEAVE

    // Setter for employee
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // Setter for date
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getters for the fields can also be added if needed
    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

}
