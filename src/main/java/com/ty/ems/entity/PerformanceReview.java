package com.ty.ems.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PerformanceReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate reviewDate;
    private int score;       // e.g., 1-10 scale
    private String remarks;

    // Constructors
    public PerformanceReview() {}

    public PerformanceReview(Employee employee, LocalDate reviewDate, int score, String remarks) {
        this.employee = employee;
        this.reviewDate = reviewDate;
        this.score = score;
        this.remarks = remarks;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public LocalDate getReviewDate() { return reviewDate; }
    public void setReviewDate(LocalDate reviewDate) { this.reviewDate = reviewDate; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
