package com.express.controller;

import com.express.model.UserEmployee;
import com.express.model.request.Employee;
import com.express.model.response.EmployeesDTO;
import com.express.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/employee/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<EmployeesDTO> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee")
    public EmployeesDTO getEmployeeById(@RequestParam String id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/register")
    public EmployeesDTO registerEmployee(@RequestBody Employee userEmployee) {
        return employeeService.postEmployee(userEmployee);
    }

    @PostMapping("/update")
    public UserEmployee updateEmployee(@RequestBody UserEmployee userEmployee) {
        return userEmployee;
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestParam String idEmployee) {

    }
}
