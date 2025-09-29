package com.ty.ems.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ems.entity.Attendance;
import com.ty.ems.entity.Employee;
import com.ty.ems.repository.AttendanceRepository;
import com.ty.ems.repository.EmployeeRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Log attendance for an employee
    public Attendance logAttendance(Long employeeId, LocalDate date, String status) {
        Optional<Employee> empOpt = employeeRepository.findById(employeeId);
        if (empOpt.isPresent()) {
            Attendance attendance = new Attendance();
            attendance.setEmployee(empOpt.get());
            attendance.setDate(date);
            attendance.setStatus(status);
            return attendanceRepository.save(attendance);
        }
        return null;
    }

    // Get all attendance records
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // Get attendance by employee
    public List<Attendance> getAttendanceByEmployee(Employee employee) {
        return attendanceRepository.findByEmployee(employee);
    }

    // Get employee by username (helper for employee login)
    public Employee getEmployeeByUser(String username) {
        return employeeRepository.findAll()
                .stream()
                .filter(emp -> emp.getUser().getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}