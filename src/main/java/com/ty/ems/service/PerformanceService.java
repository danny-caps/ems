package com.ty.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ems.entity.Employee;
import com.ty.ems.entity.PerformanceReview;
import com.ty.ems.repository.EmployeeRepository;
import com.ty.ems.repository.PerformanceReviewRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceReviewRepository reviewRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Add performance review
    public PerformanceReview addReview(Long employeeId, LocalDate reviewDate, int score, String remarks) {
        Optional<Employee> empOpt = employeeRepository.findById(employeeId);
        if (empOpt.isPresent()) {
            PerformanceReview review = new PerformanceReview();
            review.setEmployee(empOpt.get());
            review.setReviewDate(reviewDate);
            review.setScore(score);
            review.setRemarks(remarks);
            return reviewRepository.save(review);
        }
        return null;
    }

    // Get reviews by employee
    public List<PerformanceReview> getReviewsByEmployee(Employee employee) {
        return reviewRepository.findByEmployee(employee);
    }

    // Get all reviews
    public List<PerformanceReview> getAllReviews() {
        return reviewRepository.findAll();
    }
}
