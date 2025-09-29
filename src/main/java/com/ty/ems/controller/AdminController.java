package com.ty.ems.controller;

import com.ty.ems.entity.Employee;
import com.ty.ems.entity.Payroll;
import com.ty.ems.entity.PerformanceReview;
import com.ty.ems.service.EmployeeService;
import com.ty.ems.service.PayrollService;
import com.ty.ems.service.PerformanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PayrollService payrollService;

    @Autowired
    private PerformanceService performanceService;

    // Admin Dashboard
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "/dashboard";
    }

    // Add Employee Form
    @GetMapping("/add-employee")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "admin/add-employee";
    }

    @PostMapping("/add-employee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/dashboard";
    }

    // Payroll Management
    @GetMapping("/payroll")
    public String payrollPage(Model model) {
        model.addAttribute("payrolls", payrollService.getAllPayroll());
        return "/payroll";
    }

    @PostMapping("/add-payroll")
    public String addPayroll(@RequestParam Long employeeId,
                             @RequestParam String month,
                             @RequestParam double salaryPaid,
                             @RequestParam double bonus,
                             @RequestParam double deductions) {
        payrollService.addPayroll(employeeId, month, salaryPaid, bonus, deductions);
        return "redirect:/payroll";
    }

    // Performance Review Management
    @GetMapping("/performance")
    public String performancePage(Model model) {
        model.addAttribute("reviews", performanceService.getAllReviews());
        return "/performance";
    }

    @PostMapping("/add-review")
    public String addReview(@RequestParam Long employeeId,
                            @RequestParam String reviewDate,
                            @RequestParam int score,
                            @RequestParam String remarks) {
        LocalDate date = LocalDate.parse(reviewDate);
        performanceService.addReview(employeeId, date, score, remarks);
        return "redirect:/performance";
    }
}
