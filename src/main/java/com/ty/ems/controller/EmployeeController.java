package com.ty.ems.controller;

import com.ty.ems.entity.Employee;
import com.ty.ems.entity.Attendance;
import com.ty.ems.service.AttendanceService;
import com.ty.ems.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/attendance")
    public String viewAttendance(Model model, @AuthenticationPrincipal UserDetails user) {
        Employee emp = attendanceService.getEmployeeByUser(user.getUsername());
        List<Attendance> attendanceList = attendanceService.getAttendanceByEmployee(emp);
        model.addAttribute("attendance", attendanceList);
        return "employee/attendance";
    }
}
